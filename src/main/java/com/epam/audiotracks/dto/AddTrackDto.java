package com.epam.audiotracks.dto;

import java.math.BigDecimal;

public class AddTrackDto implements Dto{

    private final String name;
    private final int albumId;
    private final BigDecimal price;

    public AddTrackDto(String name, int albumId, BigDecimal price) {
        this.name = name;
        this.albumId = albumId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAlbumId() {
        return albumId;
    }
}
