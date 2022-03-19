package com.epam.audiotracks.entity;

public class Assembly implements Identifiable{

    public static final String TABLE = "assemblies";

    private final int id;
    private final String name;

    public Assembly(int id, String name) {
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
