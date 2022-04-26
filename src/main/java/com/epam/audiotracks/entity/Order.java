package com.epam.audiotracks.entity;

public class Order implements Identifiable {

    public static final String TABLE = "orders";

    private int id;
    private final int userId;
    private final int trackId;
    private final boolean isPaid;
    private final String dateTime;

    public Order(int userId, int trackId, boolean isPaid, String dateTime) {
        this.userId = userId;
        this.trackId = trackId;
        this.isPaid = isPaid;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getTrackId() {
        return trackId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getDateTime() {
        return dateTime;
    }

}
