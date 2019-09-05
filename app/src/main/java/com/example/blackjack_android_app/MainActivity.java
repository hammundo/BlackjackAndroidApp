package com.example.blackjack_android_app;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Create class objects
    Deck deck =  new Deck();
    PlayerHand playerHand = new PlayerHand();
    DealerHand dealerHand = new DealerHand();

    // Text fields
    private TextView displayPlayerHandValue;
    private TextView displayDealerHandValue;

    // Buttons
    private Button hitButton;
    private Button stickButton;

    // Global string for package name
    public static String PACKAGE_NAME;

    // Toast messages
    public static final String WIN_MSG = "Congratulation! You Won!";
    public static final String LOSE_MSG = "Better Luck Next Time!";
    public static final String DRAW_MSG = "DRAW!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get and set package name
        PACKAGE_NAME = getApplicationContext().getPackageName();

        // Initialise text fields
        displayPlayerHandValue = (TextView) findViewById(R.id.textView_playerHandValue);
        displayDealerHandValue = (TextView) findViewById(R.id.textView_dealerHandValue);

        // Initialise buttons
        hitButton = (Button) findViewById(R.id.button_hit);
        stickButton = (Button) findViewById(R.id.button_stick);

        // Game loop begins here
        gameSetUp();

        // Hit button listener
        View.OnClickListener hitButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerHand.getCardCount() < 5 && playerHand.getHandValue() != -1) {

                    playRandomCardSlideSound();
                    playerHand.addCardToHand(deck.deal());

                    // Assign the newest card to the respective placeholder card and then draw the image
                    switch (playerHand.getCardCount()) {
                        case 3:
                            ImageView placeHolderCard3 = (ImageView) findViewById(R.id.placeHolderCard3);
                            int imageResourceCase3 = getResources().getIdentifier(playerHand.getCardPathFromIndex(2), null, PACKAGE_NAME);
                            placeHolderCard3.setAlpha(1.0f);
                            placeHolderCard3.setImageResource(imageResourceCase3);
                            break;
                        case 4:
                            ImageView placeHolderCard4 = (ImageView) findViewById(R.id.placeHolderCard4);
                            int imageResourceCase4 = getResources().getIdentifier(playerHand.getCardPathFromIndex(3), null, PACKAGE_NAME);
                            placeHolderCard4.setAlpha(1.0f);
                            placeHolderCard4.setImageResource(imageResourceCase4);
                            break;
                        case 5:
                            ImageView placeHolderCard5 = (ImageView) findViewById(R.id.placeHolderCard5);
                            int imageResourceCase5 = getResources().getIdentifier(playerHand.getCardPathFromIndex(4), null, PACKAGE_NAME);
                            placeHolderCard5.setAlpha(1.0f);
                            placeHolderCard5.setImageResource(imageResourceCase5);
                            break;
                    }

                    // Update the display text that shows the value of cards held by the player
                    if(playerHand.getHandValue() == -1) {
                        // Bust
                        displayPlayerHandValue.setText("BUST");
                        lose();
                    } else if(playerHand.getHandValue() == 21) {
                        displayPlayerHandValue.setText("BLACKJACK");
                        win();
                    } else {
                        displayPlayerHandValue.setText(Integer.toString(playerHand.getHandValue()));
                    }
                }
            }
        };
        hitButton.setOnClickListener(hitButtonListener);

        // Stick button listener
        View.OnClickListener stickButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the hit button
                hitButton.setEnabled(false);

                // Start the dealers turn
                dealerMove();

            }
        };
        stickButton.setOnClickListener(stickButtonListener);

    }

    // == PRIVATE METHODS ==

    // Deals the first two cards to the player, and the first card to the dealer face up.
    // Then deals the second card to the dealer but is drawn face down.
    private void gameSetUp() {

        //Create a new deck of cards and shuffle
        deck.reloadDeck();

        // == PLAYER SETUP ==
        // Card 1
        playerHand.addCardToHand(deck.deal());
        ImageView placeHolderCard1 = (ImageView) findViewById(R.id.placeHolderCard1);
        int imageResource = getResources().getIdentifier(playerHand.getCardPathFromIndex(0), null, PACKAGE_NAME);
        placeHolderCard1.setImageResource(imageResource);

        // Card 2
        playerHand.addCardToHand(deck.deal());
        ImageView placeHolderCard2 = (ImageView) findViewById(R.id.placeHolderCard2);
        imageResource = getResources().getIdentifier(playerHand.getCardPathFromIndex(1), null, PACKAGE_NAME);
        placeHolderCard2.setImageResource(imageResource);

        // Display the value of the players current hand
        displayPlayerHandValue.setText(String.valueOf(playerHand.getHandValue()));

        // == DEALER SETUP ==
        // Card 1
        dealerHand.addCardToHand(deck.deal());
        ImageView dealerPlaceHolderCard1 = (ImageView) findViewById(R.id.dealerPlaceHolderCard1);
        imageResource = getResources().getIdentifier(dealerHand.getCardPathFromIndex(0), null, PACKAGE_NAME);
        dealerPlaceHolderCard1.setImageResource(imageResource);

        // Display the value of the dealers current hand (BEFORE ADDING THE SECOND CARD)
        displayDealerHandValue.setText(String.valueOf(dealerHand.getHandValue()));

        // Card 2 (Face down but still added to the dealers card array)
        dealerHand.addCardToHand(deck.deal());
        ImageView dealerPlaceHolderCard2 = (ImageView) findViewById(R.id.dealerPlaceHolderCard2);
        imageResource = getResources().getIdentifier("@drawable/card_back", null, PACKAGE_NAME);
        dealerPlaceHolderCard2.setImageResource(imageResource);

        //Enable the hit button
        hitButton.setEnabled(true);
    }

    // Clear the hand of both player and dealer then reload the deck and shuffle.
    private void resetHandsAndDeck() {
        playerHand.discardHand();
        dealerHand.discardHand();
        deck.reloadDeck();

        // == NOTE ==
        // Cards 1 and 2 for both the player and dealer do not need to be removed.
        // When a new game begins the player and dealer cards 1 and 2 will be updated there.

        // Remove old cards from the field
        // Player card 3, 4 and 5
        ImageView placeHolderCard3 = (ImageView) findViewById(R.id.placeHolderCard3);
        placeHolderCard3.setAlpha(0.0f);
        ImageView placeHolderCard4 = (ImageView) findViewById(R.id.placeHolderCard4);
        placeHolderCard4.setAlpha(0.0f);
        ImageView placeHolderCard5 = (ImageView) findViewById(R.id.placeHolderCard5);
        placeHolderCard5.setAlpha(0.0f);

        // Dealer cards 3, 4 and 5
        ImageView dealerPlaceHolderCard3 = (ImageView) findViewById(R.id.dealerPlaceHolderCard3);
        dealerPlaceHolderCard3.setAlpha(0.0f);
        ImageView dealerPlaceHolderCard4 = (ImageView) findViewById(R.id.dealerPlaceHolderCard4);
        dealerPlaceHolderCard4.setAlpha(0.0f);
        ImageView dealerPlaceHolderCard5 = (ImageView) findViewById(R.id.dealerPlaceHolderCard5);
        dealerPlaceHolderCard5.setAlpha(0.0f);
    }

    // When called, plays one of the card sliding sounds.
    private void playRandomCardSlideSound() {
        int rng = new Random().nextInt(8);

        //TODO: Re-design this to use one media player and to also free resources up after use.
        //  REMINDER: Try using stringbuilder to pass R.raw.SOUNDFILENAME
        switch (rng) {
            case 0:
                final MediaPlayer slide0 = MediaPlayer.create(this, R.raw.slide_a);
                slide0.start();
                break;
            case 1:
                final MediaPlayer slide1 = MediaPlayer.create(this, R.raw.slide_b);
                slide1.start();
                break;
            case 2:
                final MediaPlayer slide2 = MediaPlayer.create(this, R.raw.slide_c);
                slide2.start();
                break;
            case 3:
                final MediaPlayer slide3 = MediaPlayer.create(this, R.raw.slide_d);
                slide3.start();
                break;
            case 4:
                final MediaPlayer slide4 = MediaPlayer.create(this, R.raw.slide_e);
                slide4.start();
                break;
            case 5:
                final MediaPlayer slide5 = MediaPlayer.create(this, R.raw.slide_f);
                slide5.start();
                break;
            case 6:
                final MediaPlayer slide6 = MediaPlayer.create(this, R.raw.slide_g);
                slide6.start();
                break;
            case 7:
                final MediaPlayer slide7 = MediaPlayer.create(this, R.raw.slide_h);
                slide7.start();
                break;

        }
    }

    // Logic for the dealer, after the player has completed their turn.
    // TODO: ADD BETTER DESCRIPTION
    private void dealerMove() {

        // First reveal the dealers face down card
        ImageView dealerPlaceHolderCard2 = (ImageView) findViewById(R.id.dealerPlaceHolderCard2);
        int imageResource = getResources().getIdentifier(dealerHand.getCardPathFromIndex(1),null,PACKAGE_NAME);
        dealerPlaceHolderCard2.setImageResource(imageResource);

        // Check to see if the dealers hand value is lower, if so the dealer hits
        if(dealerHand.getHandValue() < playerHand.getHandValue()) {

            // Deal and draw the next card (Card 3)
            dealerHand.addCardToHand(deck.deal());
            playRandomCardSlideSound();

            ImageView dealerPlaceHolderCard3 = (ImageView) findViewById(R.id.dealerPlaceHolderCard3);
            int imageResourceCase3 = getResources().getIdentifier(dealerHand.getCardPathFromIndex(2), null, PACKAGE_NAME);
            dealerPlaceHolderCard3.setAlpha(1.0f);
            dealerPlaceHolderCard3.setImageResource(imageResourceCase3);

            //Check to see if the dealer is bust
            if(dealerHand.getHandValue() == -1){
                // dealer is bust
                win();
            } else if(dealerHand.getHandValue() == playerHand.getHandValue()) {
                // dealer intentionally goes for a draw if possible
                draw();
            } else if(dealerHand.getHandValue() > playerHand.getHandValue()) {
                // dealer takes the win
                lose();
            } else {
                // Deal and draw the next card (Card 4)
                dealerHand.addCardToHand(deck.deal());
                playRandomCardSlideSound();

                ImageView dealerPlaceHolderCard4 = (ImageView) findViewById(R.id.dealerPlaceHolderCard4);
                int imageResourceCase4 = getResources().getIdentifier(dealerHand.getCardPathFromIndex(3), null, PACKAGE_NAME);
                dealerPlaceHolderCard4.setAlpha(1.0f);
                dealerPlaceHolderCard4.setImageResource(imageResourceCase4);

                //Check to see if the dealer is bust
                if(dealerHand.getHandValue() == 0){
                    // dealer is bust
                    win();
                } else if(dealerHand.getHandValue() == playerHand.getHandValue()) {
                    // dealer intentionally goes for a draw if possible
                    draw();
                } else if(dealerHand.getHandValue() > playerHand.getHandValue()) {
                    // dealer takes the win
                    lose();
                } else {
                    // Deal and draw the final card (card 5)
                    dealerHand.addCardToHand(deck.deal());
                    playRandomCardSlideSound();

                    ImageView dealerPlaceHolderCard5 = (ImageView) findViewById(R.id.dealerPlaceHolderCard5);
                    int imageResourceCase5 = getResources().getIdentifier(dealerHand.getCardPathFromIndex(4), null, PACKAGE_NAME);
                    dealerPlaceHolderCard5.setAlpha(1.0f);
                    dealerPlaceHolderCard5.setImageResource(imageResourceCase5);

                    //Check to see if the dealer is bust
                    if(dealerHand.getHandValue() == 0) {
                        // dealer is bust
                        win();
                    } else if(dealerHand.isFiveCardTrick()) {
                        // dealer has a 5 card trick

                        // check to see if the player has a 5 card trick
                        if(playerHand.isFiveCardTrick()) {
                            // both the dealer and the player have a 5 card trick

                            if(dealerHand.getHandValue() > playerHand.getHandValue()) {
                                // ai hand value is higher
                                lose();
                            } else if(dealerHand.getHandValue() < playerHand.getHandValue()) {
                                // ai hand value is lower
                                win();
                            } else if(dealerHand.getHandValue() == playerHand.getHandValue()) {
                                // both the dealer and the player have a 5 card trick...
                                // ... and also have the same hand value
                                draw();
                            }
                        } else {
                            // the dealer has a 5 card trick but the player does not
                            lose();
                        }
                    }
                }
            }
        } else if(dealerHand.getHandValue() == playerHand.getHandValue()) {
            // dealer intentionally goes for a draw if possible
            draw();
        } else if(dealerHand.getHandValue() > playerHand.getHandValue()) {
            // dealer takes the win
            lose();
        }
    }

    private void win() {
        displayGameResultMessage(1);
        //pauseApp();
        resetHandsAndDeck();
        gameSetUp();
    }

    private void lose() {
        displayGameResultMessage(2);
        //pauseApp();
        resetHandsAndDeck();
        gameSetUp();
    }

    private void draw(){
        displayGameResultMessage(3);
        //pauseApp();
        resetHandsAndDeck();
        gameSetUp();
    }

    // Displays a toast message depending on which of the win(), lose() or draw() methods was called
    private void displayGameResultMessage(int i) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        switch (i) {
            case 1:
                // toast win
                Toast winToast = Toast.makeText(context, "YOU WIN", duration);
                winToast.show();
                break;
            case 2:
                // toast lose
                Toast loseToast = Toast.makeText(context, "YOU LOSE", duration);
                loseToast.show();
                break;
            case 3:
                // toast draws
                Toast drawToast = Toast.makeText(context, "DRAW", duration);
                break;
        }
    }

}
