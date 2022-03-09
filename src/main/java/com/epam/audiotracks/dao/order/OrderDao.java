package com.epam.audiotracks.dao.order;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.dto.AudioOrderDto;
import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.exeption.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {

    void save(Order order) throws DaoException;

    void update(int id) throws DaoException;

    List<AudioOrderDto> findUnpaidOrdersByUserId(int id) throws DaoException;

    List<AudioOrderDto> findPaidOrdersByUserId(int id) throws DaoException;

}
