package com.epam.audiotracks.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger logger = LogManager.getLogger();

    public static ProxyConnection create(ConnectionPool pool) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        logger.debug("Driver was registered");
        String url = "jdbc:mysql://localhost:3306/audiotracks";
        String user = "root";
        String pass = "root";
        logger.debug("Creating connection");
        return new ProxyConnection(DriverManager.getConnection(url, user, pass), pool);
    }
}
