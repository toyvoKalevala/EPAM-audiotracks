package com.epam.audiotracks.service.feedback;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.feedback.FeedbackDao;
import com.epam.audiotracks.dao.order.OrderDao;
import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger logger = LogManager.getLogger();
    private final DaoHelperFactory daoHelperFactory;

    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void createFeedback(Feedback feedback) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            FeedbackDao feedbackDao = daoHelper.createFeedbackDao();
            feedbackDao.save(feedback);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
