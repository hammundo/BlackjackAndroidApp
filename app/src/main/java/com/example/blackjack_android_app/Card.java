package com.example.blackjack_android_app;

public class Card {

    private String name;
    private String path;
    private int value;

    public Card(String name, int value, String path) {
        this.name = name;
        this.path = path;
        this.value = value;

    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public int getValue() {
        return this.value;
    }

}
