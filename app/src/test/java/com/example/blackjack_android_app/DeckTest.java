package com.example.blackjack_android_app;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    // This tests the deal() and reloadDeck() methods, as reloadDeck() is a dependency.
    @Test
    public void deal() {
        final int expected = 1;
        final int actual;

        PlayerHand testHand = new PlayerHand();
        Deck testDeck = new Deck();

        testDeck.reloadDeck();
        testHand.addCardToHand(testDeck.deal());

        actual = testHand.getCardCount();

        Assert.assertEquals(actual, expected);
    }

    // Due to the nature of SecureRandom, this test should pass the majority of the time.
    // However it is very unlikely that the same card will be drawn both times.
    @Test
    public void shuffle() {
        Deck testDeck = new Deck();

        // Load deck
        testDeck.reloadDeck();
        // Assign top card
        final Card card1 = testDeck.deal();

        // Reload deck with shuffle
        testDeck.reloadDeck();
        // Assign top card
        final Card card2 = testDeck.deal();

        // Print card objects
        System.out.println(card1.getName());
        System.out.println(card2.getName());

        Assert.assertNotEquals(card1.getName(), card2.getName());
    }
}