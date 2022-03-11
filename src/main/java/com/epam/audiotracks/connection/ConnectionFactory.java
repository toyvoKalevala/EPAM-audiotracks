package com.epam.audiotracks.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final Logger logger = LogManager.getLogger();

    public static ProxyConnection create(ConnectionPool pool) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        logger.debug("Driver was registered");
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        String url = "jdbc:mysql://localhost:3306/audiotracks";
        logger.debug("Creating connection");
        return new ProxyConnection(DriverManager.getConnection(url, properties), pool);
    }

}
