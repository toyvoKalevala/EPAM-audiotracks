package com.epam.audiotracks.dao.user;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.dao.user.UserDao;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.rowmapper.UserRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = MD5(?)";

    private static final Logger logger = LogManager.getLogger();

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return User.TABLE;
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                new UserRowMapper(),
                login,
                password);
    }
}
