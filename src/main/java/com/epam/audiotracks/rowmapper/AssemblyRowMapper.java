package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.entity.Assembly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssemblyRowMapper implements RowMapper<Assembly> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Assembly map(ResultSet resultSet) throws SQLException {
        return new Assembly(resultSet.getInt("id"),
                resultSet.getString("name"));
    }

}
