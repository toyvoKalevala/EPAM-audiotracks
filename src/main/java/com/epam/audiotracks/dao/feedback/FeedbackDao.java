package com.epam.audiotracks.dao.feedback;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;

import java.util.List;

public interface FeedbackDao extends Dao {

    List<Feedback> getAll() throws DaoException;
}
