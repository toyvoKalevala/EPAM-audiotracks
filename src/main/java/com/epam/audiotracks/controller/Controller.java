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
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page;
        try {
            String commandLine = request.getParameter("command");
            CommandFactory commandFactory = new CommandFactory();
            Command command = commandFactory.createCommand(commandLine);
            page = command.execute(request, response);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            page = "WEB-INF/view/index.jsp";
        }

        if (request.getAttribute("redirect") == "true") {
            response.sendRedirect(page);
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }

    }

}
