package com.epam.audiotracks.rowmapper.dto;

import com.epam.audiotracks.dto.TracksOrderDto;
import com.epam.audiotracks.rowmapper.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AudioOrderDtoRowMapper implements RowMapper<TracksOrderDto> {
    @Override
    public TracksOrderDto map(ResultSet resultSet) throws SQLException {
        int trackId = resultSet.getInt("id");
        String trackName = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        String orderDate = resultSet.getString("order_date");
        return new TracksOrderDto(trackId, trackName, price, orderDate);
    }
}
