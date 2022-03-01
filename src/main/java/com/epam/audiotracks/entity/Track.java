package com.epam.audiotracks.entity;

public class Track implements Identifiable {

    private String name;

    public Track(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
