package com.epam.audiotracks.dto;

import java.math.BigDecimal;

public class TracksOrderDto implements Dto {

    private final int trackId;
    private final String trackName;
    private final BigDecimal price;
    private final String orderDate;

    public TracksOrderDto(int trackId, String trackName, BigDecimal price, String orderDate) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.price = price;
        this.orderDate = orderDate;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getOrderDate() {
        return orderDate;
    }

}
