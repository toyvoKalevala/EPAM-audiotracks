package com.epam.audiotracks.dao.feedback;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.entity.Feedback;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.rowmapper.FeedbackRowMapper;
import com.epam.audiotracks.rowmapper.TrackRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class FeedbackDaoImpl extends AbstractDao<Feedback> implements FeedbackDao {

    private static final String GET_ALL_FEEDBACKS = "SELECT * FROM feedbacks";

    private static final Logger logger = LogManager.getLogger();

    public FeedbackDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Feedback> getAll() throws DaoException {
        return executeQuery(GET_ALL_FEEDBACKS, new FeedbackRowMapper());
    }
}
