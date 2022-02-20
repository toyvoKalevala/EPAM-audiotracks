package com.epam.audiotracks.dao;

import com.epam.audiotracks.connection.ConnectionCreator;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {


    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {

        Connection connection = null;
        String query = "SELECT LOGIN, PASSWORD FROM users WHERE LOGIN = ? AND PASSWORD = MD5(?)";

        try {
            connection = ConnectionCreator.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getString(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(connection);
        }
        return Optional.empty();
    }

    @Override
    public void close(Connection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
