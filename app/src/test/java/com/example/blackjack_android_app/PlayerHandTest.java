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
    public void calculateHandValueWithDoubleCards() {
        final int expected = 14;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        // == NOTE =
        // There should be no way for the player to have 2 of the same card, testing regardless.
        testHand.addCardToHand(testDeck.sevenOfHearts);
        testHand.addCardToHand(testDeck.sevenOfHearts);

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
        final int expected = 0;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfSpades);
        testHand.addCardToHand(testDeck.aceOfHearts);
        testHand.addCardToHand(testDeck.aceOfClubs);
        testHand.addCardToHand(testDeck.aceOfDiamonds);
        testHand.discardHand();

        actual = testHand.getCardCount();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAmountOfAcesInHandNoAces() {
        final int expected = 0;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.kingOfClubs);
        testHand.addCardToHand(testDeck.kingOfHearts);

        actual = testHand.getAmountOfAcesInHand();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAmountOfAcesInHandManyAces() {
        final int expected = 4;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfSpades);
        testHand.addCardToHand(testDeck.aceOfHearts);
        testHand.addCardToHand(testDeck.aceOfClubs);
        testHand.addCardToHand(testDeck.aceOfDiamonds);

        actual = testHand.getAmountOfAcesInHand();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getCardPathFromIndex() {
        final String expected = "@drawable/ace_of_hearts";
        final String actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testHand.addCardToHand(testDeck.aceOfHearts);

        actual = testHand.getCardPathFromIndex(0);

        Assert.assertEquals(actual, expected);
    }

}