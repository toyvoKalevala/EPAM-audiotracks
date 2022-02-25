package com.epam.audiotracks.controller;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.command.CommandFactory;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException {
        String commandLine = request.getParameter("command");
        logger.info("Got command");
        CommandFactory commandFactory = new CommandFactory();
        logger.info("Create CommandFactory");
        Command command = commandFactory.createCommand(commandLine);
        logger.info("Create Command");
        String page = command.execute(request, response);
        logger.info("Execute command");
        request.getRequestDispatcher(page).forward(request, response);
    }
}
