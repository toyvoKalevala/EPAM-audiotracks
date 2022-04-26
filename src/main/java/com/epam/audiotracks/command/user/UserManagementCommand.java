package com.epam.audiotracks.command.user;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserManagementCommand implements Command {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger();

    public UserManagementCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        return "WEB-INF/view/pages/userManagementPage.jsp";
    }
}
