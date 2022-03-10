package com.epam.audiotracks.service.user;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.order.OrderDao;
import com.epam.audiotracks.dao.user.UserDao;
import com.epam.audiotracks.dto.TracksOrderDto;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger();
    private final DaoHelperFactory daoHelperFactory;

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            logger.debug("Try to create userDao");
            UserDao userDao = daoHelper.createUserDao();
            logger.debug("Create userDao");
            return userDao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeUserDiscount(int discount, int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao dao = daoHelper.createUserDao();
            dao.changeUserDiscountByID(discount, id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TracksOrderDto> getUnpaidUserOrders(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            return orderDao.findUnpaidOrdersByUserId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TracksOrderDto> getPaidUserOrders(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            return orderDao.findPaidOrdersByUserId(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
