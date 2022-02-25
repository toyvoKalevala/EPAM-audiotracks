package com.epam.audiotracks.command;

import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger();

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        logger.debug("Got login");
        String password = request.getParameter("password");
        logger.debug("Got password");
        Optional<User> user = userService.login(login, password);
        logger.info("Get user from DB");
        if (user.isPresent()) {
            request.getSession().setAttribute("user", login);
            logger.info("Credentials OK");
            return "WEB-INF/view/main.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials");
            logger.error("Invalid credentials");
            return "index.jsp";
        }
    }
}
