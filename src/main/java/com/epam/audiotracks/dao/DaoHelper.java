package com.epam.audiotracks.dao;

import com.epam.audiotracks.connection.ConnectionPool;
import com.epam.audiotracks.connection.ProxyConnection;
import com.epam.audiotracks.dao.feedback.FeedbackDao;
import com.epam.audiotracks.dao.feedback.FeedbackDaoImpl;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.dao.track.TrackDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    private static final Logger logger = LogManager.getLogger();

    public DaoHelper(ConnectionPool connectionPool) {
        this.connection = connectionPool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public TrackDao createTrackDao() {
        return new TrackDaoImpl(connection);
    }

    public FeedbackDao createFeedbackDao() {
        return new FeedbackDaoImpl(connection);
    }

    @Override
    public void close() {
        connection.returnConnection();
    }
}
