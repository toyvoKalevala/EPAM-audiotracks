package com.epam.audiotracks.controller;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.command.CommandFactory;
import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.feedback.FeedbackDao;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException | DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException | DaoException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        String commandLine = request.getParameter("command");
        logger.info("Got command");
        CommandFactory commandFactory = new CommandFactory();
        logger.info("Create CommandFactory");
        Command command = commandFactory.createCommand(commandLine);
        logger.info("Create Command");
        String page = command.execute(request, response);
        logger.info("Execute command");
//        request.setAttribute("tracks", generateTracksList());
//        request.setAttribute("feedbacks", generateFeedbacksList());
        request.getRequestDispatcher(page).forward(request, response);
    }

    private List<Track> generateTracksList() throws DaoException {
        DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
        DaoHelper daoHelper = daoHelperFactory.create();
        TrackDao trackDao = daoHelper.createTrackDao();
        List<Track> tracks = trackDao.getAll();
        List<Track> listOfThree = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            listOfThree.add(i, tracks.get(i));
        }
        return listOfThree;
    }

    private List<Feedback> generateFeedbacksList() throws DaoException {
        DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
        DaoHelper daoHelper = daoHelperFactory.create();
        FeedbackDao feedbackDao = daoHelper.createFeedbackDao();
        List<Feedback> feedbacks = feedbackDao.getAll();
        List<Feedback> listOfThree = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            listOfThree.add(i, feedbacks.get(i));
        }
        return listOfThree;
    }
}
