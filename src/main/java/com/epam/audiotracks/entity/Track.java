package com.epam.audiotracks.entity;

import java.math.BigDecimal;

public class Track implements Identifiable {

    public static final String TABLE = "tracks";

    private final int id;
    private final String name;
    private final String album;
    private final BigDecimal price;
    private final int isBlocked;

    public Track(int id, String name, String album, BigDecimal price, int isBlocked) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.price = price;
        this.isBlocked = isBlocked;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAlbum() {
        return album;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

}
