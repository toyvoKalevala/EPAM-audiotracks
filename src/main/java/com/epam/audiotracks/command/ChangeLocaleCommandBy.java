package com.epam.audiotracks.command;

import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ChangeLocaleCommandBy implements Command {

    private static final String MAIN_PAGE = "WEB-INF/view/mainPage.jsp";
    private static final String LOGIN_PAGE = "WEB-INF/view/index.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        session.setAttribute("locale", "by");
        session.setAttribute("langImg", "static/images/by.jpg");
        Optional user = (Optional) session.getAttribute("user");
        if (user != null) {
            return MAIN_PAGE;
        } else {
            return LOGIN_PAGE;
        }
    }
}
