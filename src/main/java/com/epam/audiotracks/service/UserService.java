package com.epam.audiotracks.service;

import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;

import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;
}
