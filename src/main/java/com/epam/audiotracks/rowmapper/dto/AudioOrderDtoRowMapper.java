package com.epam.audiotracks.rowmapper.dto;

import com.epam.audiotracks.dto.AudioOrderDto;
import com.epam.audiotracks.rowmapper.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AudioOrderDtoRowMapper implements RowMapper<AudioOrderDto> {
    @Override
    public AudioOrderDto map(ResultSet resultSet) throws SQLException {
        String trackName = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        String orderDate = resultSet.getString("order_date");
        return new AudioOrderDto(trackName, price, orderDate);
    }
}
