package com.epam.audiotracks.command;

import com.epam.audiotracks.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger();

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userService.login(login, password)) {
            request.getSession().setAttribute("user", "admin");
            logger.info("Credentials OK");
            return "WEB-INF/view/main.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials");
            logger.error("Invalid credentials");
            return "index.jsp";
        }
    }
}
