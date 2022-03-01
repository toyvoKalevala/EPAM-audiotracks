package com.epam.audiotracks.entity;

public class Feedback implements Identifiable{

    private String text;

    public Feedback(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
