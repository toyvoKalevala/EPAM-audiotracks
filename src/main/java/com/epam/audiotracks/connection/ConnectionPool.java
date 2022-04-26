package com.epam.audiotracks.connection;

import com.epam.audiotracks.exeption.ConnectionRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger();

    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;
    private static ConnectionPool instance;

    private static final ReentrantLock connectionsLock = new ReentrantLock();
    private static final ReentrantLock instanceLock = new ReentrantLock();

    private static final int NUM_OF_CONNECTIONS = 50;
    private static final Semaphore SEMAPHORE = new Semaphore(NUM_OF_CONNECTIONS);

    public ConnectionPool(Queue<ProxyConnection> availableConnections, Queue<ProxyConnection> connectionsInUse) {
        this.availableConnections = availableConnections;
        this.connectionsInUse = connectionsInUse;
    }

    public static ConnectionPool getInstance() {
        ConnectionPool connectionPool = instance;
        if (connectionPool == null) {
            instanceLock.lock();
            try {
                connectionPool = instance;
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool(new ArrayDeque<>(), new ArrayDeque<>());
                    connectionPool.createConnections(connectionPool);
                    instance = connectionPool;
                }
            } finally {
                instanceLock.unlock();
            }
        }
        return instance;
    }

    private void createConnections(ConnectionPool connectionPool) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        int poolSize = Integer.parseInt(resourceBundle.getString("db.poolsize"));
        connectionsLock.lock();
        try {
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection = ConnectionFactory.create(connectionPool);
                connectionPool.availableConnections.offer(connection);
            }
        } catch (SQLException e) {
            logger.error(new ConnectionRuntimeException(e));
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            SEMAPHORE.acquire();
            connectionsLock.lock();
            connection = availableConnections.poll();
            connectionsInUse.offer(connection);
        } catch (InterruptedException e) {
            logger.error(new ConnectionRuntimeException(e));
        } finally {
            connectionsLock.unlock();
        }
        return connection;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionsLock.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                connectionsInUse.remove(proxyConnection);
                availableConnections.offer(proxyConnection);
                logger.info("Connection was returned");
                SEMAPHORE.release();
            }
        } finally {
            connectionsLock.unlock();
        }
    }

}
