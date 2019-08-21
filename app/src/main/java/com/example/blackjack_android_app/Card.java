package com.example.blackjack_android_app;

public class Card {

    // Object Properties
    private String name;
    private String path;
    private int value;
    private int secondValue;

    public Card(String name, int value, String path) {
        this.name = name;
        this.path = path;
        this.value = value;

        // Set secondValue to 11 if card is an ace. Otherwise secondValue is the same as value.
        // This is used to handle ace being 1 or 11.
        if(this.value == 1) {
            this.secondValue = 11;
        } else {
            this.secondValue = this.value;
        }
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

    public int getSecondValue() {
        return this.secondValue;
    }
}
