package com.epam.audiotracks.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static final Logger logger = LogManager.getLogger();

    public static ProxyConnection create(ConnectionPool pool) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");
        return new ProxyConnection(DriverManager.getConnection(url, user, password), pool);
    }

}
