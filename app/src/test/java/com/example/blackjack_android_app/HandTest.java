package com.example.blackjack_android_app;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

    @Test
    public void addCardToHand() {
        final int expected = 5;
        final int actual;

        Hand testHand = new Hand();

        Card TestAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card TestAceOfClubs = new Card("Test Ace of Hearts",1,"Test");
        Card TestAceOfHearts = new Card("Test Ace of Clubs",1,"Test");
        Card TestAceOfDiamonds = new Card("Test Ace of Diamonds",1,"Test");
        Card TestKingOfSpades = new Card("Test King of Spades", 10, "Test");
        Card TestQueenOfDiamonds = new Card("Test Queen of Diamonds", 10, "Test");

        testHand.addCardToHand(TestAceOfSpades);
        testHand.addCardToHand(TestAceOfClubs);
        testHand.addCardToHand(TestAceOfHearts);
        testHand.addCardToHand(TestAceOfDiamonds);
        testHand.addCardToHand(TestKingOfSpades);

        // Attempt to add a 6th card to the hand, result should still be 5.
        testHand.addCardToHand(TestQueenOfDiamonds);

        actual = testHand.getCardCount();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValue() {
        final int expected = 21;
        final int actual;

        Hand testHand = new Hand();

        Card testAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card testKingOfHearts = new Card("Test King Of Hearts",10,"Test");

        testHand.addCardToHand(testAceOfSpades);
        testHand.addCardToHand(testKingOfHearts);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValueCheckForBust() {
        final int expected = -1;
        final int actual;

        Hand testHand = new Hand();

        Card testAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card testKingOfHearts = new Card("Test King Of Hearts",10,"Test");
        Card testKingOfClubs = new Card("Test King Of Clubs",10,"Test");
        Card testEightOfClubs = new Card("Test Eight Of Clubs",8,"Test");

        testHand.addCardToHand(testAceOfSpades);
        testHand.addCardToHand(testKingOfHearts);
        testHand.addCardToHand(testKingOfClubs);
        testHand.addCardToHand(testEightOfClubs);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateHandValueCheckMultipleAces() {
        final int expected = 14;
        final int actual;

        Hand testHand = new Hand();

        Card TestAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card TestAceOfClubs = new Card("Test Ace of Hearts",1,"Test");
        Card TestAceOfHearts = new Card("Test Ace of Clubs",1,"Test");
        Card TestAceOfDiamonds = new Card("Test Ace of Diamonds",1,"Test");

        testHand.addCardToHand(TestAceOfSpades);
        testHand.addCardToHand(TestAceOfClubs);
        testHand.addCardToHand(TestAceOfHearts);
        testHand.addCardToHand(TestAceOfDiamonds);

        actual = testHand.getHandValue();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void discardHand() {
        final int expected = 0;
        final int actual;

        Hand testHand = new Hand();

        Card TestAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card TestAceOfClubs = new Card("Test Ace of Hearts",1,"Test");
        Card TestAceOfHearts = new Card("Test Ace of Clubs",1,"Test");
        Card TestAceOfDiamonds = new Card("Test Ace of Diamonds",1,"Test");

        testHand.addCardToHand(TestAceOfSpades);
        testHand.addCardToHand(TestAceOfClubs);
        testHand.addCardToHand(TestAceOfHearts);
        testHand.addCardToHand(TestAceOfDiamonds);
        testHand.discardHand();

        actual = testHand.getCardCount();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAmountOfAcesInHandNoAces() {
        final int expected = 0;
        final int actual;

        Hand testHand = new Hand();

        Card testKingOfHearts = new Card("Test King Of Hearts",10,"Test");
        Card testKingOfClubs = new Card("Test King Of Clubs",10,"Test");

        testHand.addCardToHand(testKingOfHearts);
        testHand.addCardToHand(testKingOfClubs);

        actual = testHand.getAmountOfAcesInHand();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAmountOfAcesInHandManyAces() {
        final int expected = 4;
        final int actual;

        Hand testHand = new Hand();

        Card TestAceOfSpades = new Card("Test Ace of Spades",1,"Test");
        Card TestAceOfClubs = new Card("Test Ace of Hearts",1,"Test");
        Card TestAceOfHearts = new Card("Test Ace of Clubs",1,"Test");
        Card TestAceOfDiamonds = new Card("Test Ace of Diamonds",1,"Test");

        testHand.addCardToHand(TestAceOfSpades);
        testHand.addCardToHand(TestAceOfClubs);
        testHand.addCardToHand(TestAceOfHearts);
        testHand.addCardToHand(TestAceOfDiamonds);

        actual = testHand.getAmountOfAcesInHand();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getCardPathFromIndex() {
        final String expected = "@drawable/ace_of_spades";
        final String actual;

        Hand testHand = new Hand();

        Card aceOfSpades = new Card("Ace of Spades",1,"@drawable/ace_of_spades");

        testHand.addCardToHand(aceOfSpades);

        actual = testHand.getCardPathFromIndex(0);

        Assert.assertEquals(actual, expected);
    }

}