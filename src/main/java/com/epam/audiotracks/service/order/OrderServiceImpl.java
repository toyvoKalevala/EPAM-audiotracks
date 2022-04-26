package com.epam.audiotracks.service.order;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.order.OrderDao;
import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LogManager.getLogger();
    private final DaoHelperFactory daoHelperFactory;

    public OrderServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void createOrder(Order order) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            orderDao.save(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void payForOrder(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            OrderDao orderDao = daoHelper.createOrderDao();
            orderDao.update(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
