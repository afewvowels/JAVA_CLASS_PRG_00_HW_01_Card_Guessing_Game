/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_class_prg_00_hw_01_card_guessing_game;

import java.util.Random;
/**
 *
 * This class is contains methods related to the functioning of the computer's
 * hand of cards.
 * @author bluebackdev
 */
public class Hand {
    private int handSize = 5;
    /**
     * 
     * @param hand = String array that will hold the computer's individual string
     * cards once the hand has been generated
     * @param rand = Pseudorandom number generator to generate random numbers to
     * pass to hand object to get a string from the switch statement in return
     * @param card = Card object that is passed random numbers to get a string value
     * and is passed strings to validate them against the stored switch statement
     * of card names
     */
    String[] hand = new String[handSize];
    Random rand = new Random();
    Card card = new Card();
    
    /**
     * Default constructor, no arguments
     */
    public Hand() {
    }
    
    /**
     * This method is used to query the size of the hand that will be generated.
     * Default value of 5.
     * @return 
     */
    public int returnHandSize() {
        return handSize;
    }
    
    /**
     * This method is used to set the hand size to a custom value.
     * @param size The new hand size that will be generated.
     */
    public void setHandSize(int size) {
        handSize = size;
        hand = new String[handSize];
    }
    
    /**
     * This method takes an index value and returns the string title of the card
     * at that position in the computer's hand.
     * @param i Index value of a card in the computer's hand
     * @return 
     */
    public String getSingleCard(int i) {
        return hand[i];
    }
    
    /**
     * This method modifies the String[] array and replaces the default/current
     * values with newly generated card names
     */
    public void generateHand() {
        for(int i = 0 ; i < handSize ; i++) {
            hand[i] = card.getCardTitle(rand.nextInt(13) + 1);
        }
    }
    
    /**
     * This method takes the user guess in the form of a string and loops through
     * the computer's hand card by card and calls a hand method to compare the
     * two values
     * @param card The string value of the user guess passed in from main
     * @return 
     */
    public boolean searchHand(String card) {
        boolean returnValue = false;
        
        for(int i = 0 ; i < handSize ; i++) {
            if(card.compareToIgnoreCase(hand[i]) == 0) {
                returnValue = true;
            }
        }
        
        return returnValue;
    }
    
    /**
     * This method passes the users guess to the card object used by this class
     * to check if the users input is a valid string
     * @param title The users string that will be passed to this class' card
     * object for validation
     * @return 
     */
    public boolean validateCard(String title) {
        boolean returnValue = false;
        
        if(card.validateCard(title) == true) {
            returnValue = true;
        }
        
        return returnValue;
    }
}
