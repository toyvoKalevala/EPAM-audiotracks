package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Feedback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackRowMapper implements RowMapper<Feedback> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Feedback map(ResultSet resultSet) throws SQLException {
        return new Feedback(resultSet.getString("feedback_text"));
    }
}
