package com.epam.audiotracks.command.user;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return "WEB-INF/view/index.jsp";
    }
}
