package com.epam.audiotracks.entity;

public class Album implements Identifiable {

    public static final String TABLE = "albums";

    private final int id;
    private final String name;

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
