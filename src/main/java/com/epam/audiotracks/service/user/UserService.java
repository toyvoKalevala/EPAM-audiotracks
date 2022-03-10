package com.epam.audiotracks.service.user;

import com.epam.audiotracks.dto.TracksOrderDto;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    void changeUserDiscount(int discount, int id) throws ServiceException;

    List<TracksOrderDto> getUnpaidUserOrders(int id) throws ServiceException;

    List<TracksOrderDto> getPaidUserOrders(int id) throws ServiceException;

}
