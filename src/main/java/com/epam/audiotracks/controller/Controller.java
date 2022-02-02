package com.epam.audiotracks.controller;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandLine = request.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.createCommand(commandLine);
        String page = command.execute(request, response);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
