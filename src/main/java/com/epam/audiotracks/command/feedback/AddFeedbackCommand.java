package com.epam.audiotracks.command.feedback;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.feedback.FeedbackService;
import com.epam.audiotracks.service.feedback.FeedbackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFeedbackCommand implements Command {

    private final FeedbackService feedbackService;
    private static final Logger logger = LogManager.getLogger();

    public AddFeedbackCommand(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User user = (User) request.getSession().getAttribute("user");
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = format.format(date);
        String feedbackText = request.getParameter("feedbackText");
        Feedback feedback = new Feedback(user.getId(), trackId, dateTime, feedbackText);
        feedbackService.createFeedback(feedback);
        return "controller?command=userTracks";
    }

}
