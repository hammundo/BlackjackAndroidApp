package com.example.blackjack_android_app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerHandTest {

    @Test
    public void addCardToHand() {
        final int expected = 5;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfClubs);
        testHand.addCardToHand(testDeck.twoOfClubs);
        testHand.addCardToHand(testDeck.threeOfClubs);
        testHand.addCardToHand(testDeck.fourOfClubs);
        testHand.addCardToHand(testDeck.fiveOfClubs);

        // Attempt to add a 6th card to the hand, result should still be 5.
        testHand.addCardToHand(testDeck.aceOfDiamonds);

        actual = testHand.getCardCount();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValue() {
        final int expected = 21;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfSpades);
        testHand.addCardToHand(testDeck.kingOfHearts);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValueCheckForBust() {
        final int expected = -1;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfSpades);
        testHand.addCardToHand(testDeck.kingOfHearts);
        testHand.addCardToHand(testDeck.kingOfClubs);
        testHand.addCardToHand(testDeck.eightOfClubs);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValueCheckMultipleAces() {
        final int expected = 14;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfSpades);
        testHand.addCardToHand(testDeck.aceOfHearts);
        testHand.addCardToHand(testDeck.aceOfClubs);
        testHand.addCardToHand(testDeck.aceOfDiamonds);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void discardHand() {
    }

    @Test
    public void getAmountOfAcesInHand() {
    }

    @Test
    public void getCardPathFromIndex() {
    }

}