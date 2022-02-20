package com.epam.audiotracks.service;

import com.epam.audiotracks.dao.UserDao;
import com.epam.audiotracks.dao.UserDaoImpl;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.UserServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger();
    private boolean isLogin;

    @Override
    public boolean login(String login, String password) throws UserServiceException {

        UserDao userDao = new UserDaoImpl();

        try {
            if (userDao.findUserByLoginAndPassword(login, password).isPresent()) {
                User user = userDao.findUserByLoginAndPassword(login, password).get();
                String userLogin = user.getLogin();
                String userPassword = user.getPassword();
                isLogin = userLogin.equals(login) && userPassword.equals(DigestUtils.md5Hex(password));
            }
        } catch (DaoException e) {
            throw new UserServiceException(e);
        }
        return isLogin;
    }
}
