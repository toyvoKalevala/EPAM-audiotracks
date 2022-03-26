package com.epam.audiotracks.command.user;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = userService.login(login, password);
        if (user.isPresent()) {
            request.getSession().setAttribute("user", user.get());
            request.getSession().setAttribute("isAdmin", user.get().getIsAdmin());
            return "/controller?command=selectTracks";
        } else {
            request.setAttribute("errorMessage", "label.loginError");
            logger.error("Invalid credentials");
            return "WEB-INF/view/index.jsp";
        }
    }

}
