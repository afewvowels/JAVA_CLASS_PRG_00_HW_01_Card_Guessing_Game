/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_class_prg_00_hw_01_card_guessing_game;

/**
 * This class contains methods for generating individual card strings and
 * validating strings against the list of card names stored here.
 * @author bluebackdev
 */
public class Card {
    private static String cardName;
    
    /**
     * Default constructor
     */
    public Card() {
    }
    
    /**
     * This method contains a switch statement containing all the possible cards
     * for use in the program. Static for use in below validation method.
     * @param num Random number that is passed in to generate the return
     * value/card name
     * @return 
     */
    public static String getCardTitle(int num) {
        switch(num) {
            case 1:
                cardName = "ace";
                break;
            case 2:
                cardName = "two";
                break;
            case 3:
                cardName = "three";
                break;
            case 4:
                cardName = "four";
                break;
            case 5:
                cardName = "five";
                break;
            case 6:
                cardName = "six";
                break;
            case 7:
                cardName = "seven";
                break;
            case 8:
                cardName = "eight";
                break;
            case 9:
                cardName = "nine";
                break;
            case 10:
                cardName = "ten";
                break;
            case 11:
                cardName = "jack";
                break;
            case 12:
                cardName = "queen";
                break;
            case 13:
                cardName = "king";
                break;
            default:
                cardName = "ERROR";
                break;
        }
        
        return cardName;
    }
    
    /**
     * This method takes in a string value (user input from main) and checks it
     * against the switch statement in getCardTitle
     * @param title This is the input string, generally user input from main
     * @return 
     */
    public boolean validateCard(String title) {
        boolean returnValue = false;
        
        for(int i = 0 ; i < 14 ; i++) {
            if(title.compareToIgnoreCase(getCardTitle(i + 1)) == 0) {
                returnValue = true;
            }
        }
        
        return returnValue;
    }
}
