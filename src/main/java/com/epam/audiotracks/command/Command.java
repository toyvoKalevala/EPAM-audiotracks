package com.epam.audiotracks.command;

import com.epam.audiotracks.exeption.UserServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response) throws UserServiceException;

}
