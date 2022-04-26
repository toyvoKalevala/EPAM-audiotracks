package com.epam.audiotracks.entity;

public class Feedback implements Identifiable {

    private final int userId;
    private final int trackId;
    private final String dateTime;
    private final String text;

    public Feedback(int userId, int trackId, String dateTime, String text) {
        this.userId = userId;
        this.trackId = trackId;
        this.dateTime = dateTime;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getText() {
        return text;
    }

}
