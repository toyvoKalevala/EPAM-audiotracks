package com.epam.audiotracks.dao;

import com.epam.audiotracks.connection.ConnectionPool;
import com.epam.audiotracks.connection.ProxyConnection;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool connectionPool) {
        this.connection = connectionPool.getConnection();
    }

    public UserDao createUserDao() {
        return new AbstractDaoUserImpl(connection);
    }

    @Override
    public void close() {
        connection.returnConnection();
    }
}
