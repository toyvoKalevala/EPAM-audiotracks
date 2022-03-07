package com.epam.audiotracks.service.order;

import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.exeption.ServiceException;

public interface OrderService {

    void createOrder(Order order) throws ServiceException;

}
