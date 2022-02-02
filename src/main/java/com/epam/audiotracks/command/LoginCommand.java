package com.epam.audiotracks.command;

import com.epam.audiotracks.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userService.login(login, password)) {
            request.getSession().setAttribute("user", "admin");
            return "WEB-INF/view/main.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials");
            return "index.jsp";
        }
    }
}
