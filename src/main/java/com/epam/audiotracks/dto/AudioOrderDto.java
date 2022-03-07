package com.epam.audiotracks.dto;

import java.math.BigDecimal;

public class AudioOrderDto implements Dto {

    private final String trackName;
    private final BigDecimal price;
    private final String orderDate;

    public AudioOrderDto(String trackName, BigDecimal price, String orderDate) {
        this.trackName = trackName;
        this.price = price;
        this.orderDate = orderDate;
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
