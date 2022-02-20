package com.epam.audiotracks.service;

import com.epam.audiotracks.exeption.UserServiceException;
import com.google.protobuf.ServiceException;

public interface UserService {

    boolean login(String login, String password) throws UserServiceException;
}
