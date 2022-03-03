package com.epam.audiotracks.dao.track;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.rowmapper.TrackRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TrackDaoImpl extends AbstractDao<Track> implements TrackDao {

    private static final String GET_ALL_TRACKS = "SELECT * FROM tracks";

    private static final Logger logger = LogManager.getLogger();

    public TrackDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return null;
    }

    List<Track> tracks = new ArrayList<>();

    @Override
    public List<Track> getAll() throws DaoException {
        return executeQuery(GET_ALL_TRACKS, new TrackRowMapper());
    }
}
