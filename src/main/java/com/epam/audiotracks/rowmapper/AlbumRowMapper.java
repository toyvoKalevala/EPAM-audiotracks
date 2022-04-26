package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.entity.Feedback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumRowMapper implements RowMapper<Album> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Album map(ResultSet resultSet) throws SQLException {
        return new Album(resultSet.getInt("id"),
                         resultSet.getString("name"));
    }

}
