package com.epam.audiotracks.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ConnectionCreator {

    private static final Logger logger = LogManager.getLogger();

    public static Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/audiotracks", "root", "root");
    }
}
