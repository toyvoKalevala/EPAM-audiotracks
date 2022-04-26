package com.epam.audiotracks.service.feedback;

import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.exeption.ServiceException;

public interface FeedbackService {

    void createFeedback(Feedback feedback) throws ServiceException;

}
