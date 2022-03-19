package com.epam.audiotracks.dao;

import com.epam.audiotracks.connection.ConnectionPool;
import com.epam.audiotracks.connection.ProxyConnection;
import com.epam.audiotracks.dao.album.AlbumDao;
import com.epam.audiotracks.dao.album.AlbumDaoImpl;
import com.epam.audiotracks.dao.assembly.AssemblyDao;
import com.epam.audiotracks.dao.assembly.AssemblyDaoImpl;
import com.epam.audiotracks.dao.feedback.FeedbackDao;
import com.epam.audiotracks.dao.feedback.FeedbackDaoImpl;
import com.epam.audiotracks.dao.order.OrderDao;
import com.epam.audiotracks.dao.order.OrderDaoImpl;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.dao.track.TrackDaoImpl;
import com.epam.audiotracks.dao.user.UserDao;
import com.epam.audiotracks.dao.user.UserDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelper implements AutoCloseable {

    private final ProxyConnection connection;

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

    public OrderDao createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    public AlbumDao createAlbumDao() {
        return new AlbumDaoImpl(connection);
    }

    @Override
    public void close() {
        connection.returnConnection();
    }

    public AssemblyDao createAssemblyDao() {
        return new AssemblyDaoImpl(connection);
    }

}
