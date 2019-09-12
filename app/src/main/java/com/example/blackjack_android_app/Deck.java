package com.example.blackjack_android_app;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private SecureRandom sr = new SecureRandom();
    private ArrayList<Card> deck = new ArrayList<>();

    private Card aceOfSpades = new Card("Ace of Spades",1,"@drawable/ace_of_spades");
    private Card twoOfSpades = new Card("2 of Spades",2,"@drawable/two_of_spades");
    private Card threeOfSpades = new Card("3 of Spades",3,"@drawable/three_of_spades");
    private Card fourOfSpades = new Card("4 of Spades",4,"@drawable/four_of_spades");
    private Card fiveOfSpades = new Card("5 of Spades",5,"@drawable/five_of_spades");
    private Card sixOfSpades = new Card("6 of Spades",6,"@drawable/six_of_spades");
    private Card sevenOfSpades = new Card("7 of Spades",7,"@drawable/seven_of_spades");
    private Card eightOfSpades = new Card("8 of Spades",8,"@drawable/eight_of_spades");
    private Card nineOfSpades = new Card("9 of Spades",9,"@drawable/nine_of_spades");
    private Card tenOfSpades = new Card("10 of Spades",10,"@drawable/ten_of_spades");
    private Card jackOfSpades = new Card("Jack of Spades",10,"@drawable/jack_of_spades");
    private Card queenOfSpades = new Card("Queen of Spades",10,"@drawable/queen_of_spades");
    private Card kingOfSpades = new Card("King of Spades",10,"@drawable/king_of_spades");

    private Card aceOfClubs = new Card("Ace of Clubs",1,"@drawable/ace_of_clubs");
    private Card twoOfClubs = new Card("2 of Clubs",2,"@drawable/two_of_clubs");
    private Card threeOfClubs = new Card("3 of Clubs",3,"@drawable/three_of_clubs");
    private Card fourOfClubs = new Card("4 of Clubs",4,"@drawable/four_of_clubs");
    private Card fiveOfClubs = new Card("5 of Clubs",5,"@drawable/five_of_clubs");
    private Card sixOfClubs = new Card("6 of Clubs",6,"@drawable/six_of_clubs");
    private Card sevenOfClubs = new Card("7 of Clubs",7,"@drawable/seven_of_clubs");
    private Card eightOfClubs = new Card("8 of Clubs",8,"@drawable/eight_of_clubs");
    private Card nineOfClubs = new Card("9 of Clubs",9,"@drawable/nine_of_clubs");
    private Card tenOfClubs = new Card("10 of Clubs",10,"@drawable/ten_of_clubs");
    private Card jackOfClubs = new Card("Jack of Clubs",10,"@drawable/jack_of_clubs");
    private Card queenOfClubs = new Card("Queen of Clubs",10,"@drawable/queen_of_clubs");
    private Card kingOfClubs = new Card("King of Clubs",10,"@drawable/king_of_clubs");

    private Card aceOfDiamonds =  new Card("Ace of Diamonds",1,"@drawable/ace_of_diamonds");
    private Card twoOfDiamonds =  new Card("2 of Diamonds",2,"@drawable/two_of_diamonds");
    private Card threeOfDiamonds =  new Card("3 of Diamonds",3,"@drawable/three_of_diamonds");
    private Card fourOfDiamonds =  new Card("4 of Diamonds",4,"@drawable/four_of_diamonds");
    private Card fiveOfDiamonds =  new Card("5 of Diamonds",5,"@drawable/five_of_diamonds");
    private Card sixOfDiamonds =  new Card("6 of Diamonds",6,"@drawable/six_of_diamonds");
    private Card sevenOfDiamonds =  new Card("7 of Diamonds",7,"@drawable/seven_of_diamonds");
    private Card eightOfDiamonds =  new Card("8 of Diamonds",8,"@drawable/eight_of_diamonds");
    private Card nineOfDiamonds = new Card("9 of Diamonds",9,"@drawable/nine_of_diamonds");
    private Card tenOfDiamonds =  new Card("10 of Diamonds",10,"@drawable/ten_of_diamonds");
    private Card jackOfDiamonds =  new Card("Jack of Diamonds",10,"@drawable/jack_of_diamonds");
    private Card queenOfDiamonds =  new Card("Queen of Diamonds",10,"@drawable/queen_of_diamonds");
    private Card kingOfDiamonds =  new Card("King of Diamonds",10,"@drawable/king_of_diamonds");

    private Card aceOfHearts = new Card("Ace of Hearts",1,"@drawable/ace_of_hearts");
    private Card twoOfHearts = new Card("2 of Hearts",2,"@drawable/two_of_hearts");
    private Card threeOfHearts = new Card("3 of Hearts",3,"@drawable/three_of_hearts");
    private Card fourOfHearts = new Card("4 of Hearts",4,"@drawable/four_of_hearts");
    private Card fiveOfHearts = new Card("5 of Hearts",5,"@drawable/five_of_hearts");
    private Card sixOfHearts = new Card("6 of Hearts",6,"@drawable/six_of_hearts");
    private Card sevenOfHearts = new Card("7 of Hearts",7,"@drawable/seven_of_hearts");
    private Card eightOfHearts = new Card("8 of Hearts",8,"@drawable/eight_of_hearts");
    private Card nineOfHearts = new Card("9 of Hearts",9,"@drawable/nine_of_hearts");
    private Card tenOfHearts = new Card("10 of Hearts",10,"@drawable/ten_of_hearts");
    private Card jackOfHearts = new Card("Jack of Hearts",10,"@drawable/jack_of_hearts");
    private Card queenOfHearts = new Card("Queen of Hearts",10,"@drawable/queen_of_hearts");
    private Card kingOfHearts = new Card("King of Hearts",10,"@drawable/king_of_hearts");

    public Card deal() {
        Card dealtCard = deck.get(0);
        deck.remove(0);
        return dealtCard;
    }

    public void reloadDeck() {

        deck.add(aceOfSpades);
        deck.add(twoOfSpades);
        deck.add(threeOfSpades);
        deck.add(fourOfSpades);
        deck.add(fiveOfSpades);
        deck.add(sixOfSpades);
        deck.add(sevenOfSpades);
        deck.add(eightOfSpades);
        deck.add(nineOfSpades);
        deck.add(tenOfSpades);
        deck.add(jackOfSpades);
        deck.add(queenOfSpades);
        deck.add(kingOfSpades);

        deck.add(aceOfClubs);
        deck.add(twoOfClubs);
        deck.add(threeOfClubs);
        deck.add(fourOfClubs);
        deck.add(fiveOfClubs);
        deck.add(sixOfClubs);
        deck.add(sevenOfClubs);
        deck.add(eightOfClubs);
        deck.add(nineOfClubs);
        deck.add(tenOfClubs);
        deck.add(jackOfClubs);
        deck.add(queenOfClubs);
        deck.add(kingOfClubs);

        deck.add(aceOfDiamonds);
        deck.add(twoOfDiamonds);
        deck.add(threeOfDiamonds);
        deck.add(fourOfDiamonds);
        deck.add(fiveOfDiamonds);
        deck.add(sixOfDiamonds);
        deck.add(sevenOfDiamonds);
        deck.add(eightOfDiamonds);
        deck.add(nineOfDiamonds);
        deck.add(tenOfDiamonds);
        deck.add(jackOfDiamonds);
        deck.add(queenOfDiamonds);
        deck.add(kingOfDiamonds);

        deck.add(aceOfHearts);
        deck.add(twoOfHearts);
        deck.add(threeOfHearts);
        deck.add(fourOfHearts);
        deck.add(fiveOfHearts);
        deck.add(sixOfHearts);
        deck.add(sevenOfHearts);
        deck.add(eightOfHearts);
        deck.add(nineOfHearts);
        deck.add(tenOfHearts);
        deck.add(jackOfHearts);
        deck.add(queenOfHearts);
        deck.add(kingOfHearts);

        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(deck, sr);
    }

}
