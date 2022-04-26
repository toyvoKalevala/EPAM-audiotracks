package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackRowMapper implements RowMapper<Track> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Track map(ResultSet resultSet) throws SQLException {
        logger.debug("Try to create track");
        return new Track(resultSet.getInt("id"),
                         resultSet.getString("name"),
                         resultSet.getString("album"),
                         resultSet.getBigDecimal("price"),
                         resultSet.getInt("isBlocked"));
    }

}
