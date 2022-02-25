package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        logger.debug("Try to create user");
        return new User(resultSet.getString("login"), resultSet.getString("password"));
    }
}
