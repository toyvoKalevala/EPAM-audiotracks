package com.epam.audiotracks.rowmapper;

import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.entity.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        return new Order(resultSet.getInt("user_id"),
                         resultSet.getInt("track_id"),
                         resultSet.getBoolean("is_paid"),
                         resultSet.getString("order_date"));
    }

}
