package com.epam.audiotracks.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger();
    private boolean isLogin;

    @Override
    public boolean login(String login, String password) {

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiotracks", "root", "root");
            logger.info("Connected to DB");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM users");
            while (resultSet.next()) {
                String userLogin = resultSet.getString(1);
                String userPassword = resultSet.getString(2);
                isLogin = userLogin.equals(login) && userPassword.equals(password);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return isLogin;
    }
}
