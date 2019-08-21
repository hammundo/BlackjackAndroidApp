package com.example.blackjack_android_app;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerHand {

    // Object properties
    public ArrayList<Card> hand = new ArrayList<>();
    private int handValue;


    public PlayerHand() {
        this.handValue = 0;
    }

    public void addCardToHand(Card cardToAdd) {
        if(hand.size() < 5) {
            this.hand.add(cardToAdd);
            calculateHandValue();
        }
    }

    public void calculateHandValue() {

        // Sort the hand by highest to lowest value cards, with aces at the end of the list.
        Collections.sort(hand, (c1, c2) -> c1.getValue() - c2.getValue());
        Collections.reverse(hand);

        // Total the value of the hand, excluding aces.
        int value = 0;
        for(Card c : hand) {
            if(c.getValue() != 1) {
                value += c.getValue();
            }
        }

        // Will only be executed if an ace was found.
        // If aces found, check to see if an ace can be 11 or not.
        // If not, ace value is set to 1
        if(getAmountOfAcesInHand() > 0) {
            if(value + 11 + (getAmountOfAcesInHand() -1) <= 21) {
                value += 11;
                value += (getAmountOfAcesInHand() - 1);
            } else {
                value += getAmountOfAcesInHand();
            }
        }

        // If value is over 21 (Bust), then set the value of the hand to -1
        if(value > 21) {
            value = -1;
        }

        this.handValue = value;
    }



    public void discardHand() {
        this.hand.clear();
    }

    // Return the amount of ace cards in the player hand by iterating though each index.
    public int getAmountOfAcesInHand() {
        int amountOfAces = 0;

        for(Card c : hand) {
            if(c.getValue() == 1) {
                amountOfAces++;
            }
        }
        return amountOfAces;
    }

    // Get the card path based on the index parsed.
    public String getCardPathFromIndex(int i) {
        return hand.get(i).getPath();
    }

    public int getHandValue() {
        return handValue;
    }

    public int getCardCount() {
        return hand.size();
    }




}
