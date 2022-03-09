package com.epam.audiotracks.command.track;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.dto.AudioOrderDto;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.user.UserService;
import com.epam.audiotracks.service.user.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserTracksCommand implements Command {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger();

    public UserTracksCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User user = (User) request.getSession().getAttribute("user");
        List<AudioOrderDto> paidOrders = userService.getPaidUserOrders(user.getId());
        request.setAttribute("paidOrders", paidOrders);
        return "WEB-INF/view/myTracks.jsp";
    }

}
