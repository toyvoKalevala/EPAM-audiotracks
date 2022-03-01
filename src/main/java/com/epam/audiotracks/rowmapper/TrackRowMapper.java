package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackRowMapper implements RowMapper<Track> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Track map(ResultSet resultSet) throws SQLException {
        return new Track(resultSet.getString("name"));
    }
}
