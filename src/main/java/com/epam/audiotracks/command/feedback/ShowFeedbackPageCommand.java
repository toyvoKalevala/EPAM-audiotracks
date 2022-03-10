package com.epam.audiotracks.command.feedback;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.feedback.FeedbackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFeedbackPageCommand implements Command {

    private final FeedbackService feedbackService;
    private static final Logger logger = LogManager.getLogger();

    public ShowFeedbackPageCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        request.setAttribute("trackId", trackId);
        return "WEB-INF/view/addFeedbackPage.jsp";
    }

}
