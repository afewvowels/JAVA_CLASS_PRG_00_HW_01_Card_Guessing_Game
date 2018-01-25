/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_class_prg_00_hw_01_card_guessing_game;

import java.util.Scanner;
/**
 * This application generates a menu for the user to either play the game or
 * set a custom hand size.
 * @author bluebackdev
 */
public class JAVA_CLASS_PRG_00_HW_01_Card_Guessing_Game {

    /**
     * The main method contains the menu loop in its entirety
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMenu();
    }
    
    public static void showMenu() {
        int intMenuSelection = -1;
        int intHandSize;
        
        Hand hand = new Hand();
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        do {
            System.out.println("Please select from the following menu options:");
            System.out.println("\t1. Play game");
            System.out.println("\t2. Set hand size");
            System.out.println("\t3. Exit");
            System.out.print("Selection: ");
            
            intMenuSelection = scrKeyboard.nextInt();
            
            switch(intMenuSelection) {
                case 1:
                    playGame(hand);
                    break;
                case 2:
                    System.out.print("Enter a new hand size: ");
                    intHandSize = scrKeyboard.nextInt();
                    hand.setHandSize(intHandSize);
                    break;
                case 3:
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("ERROR SELECTING MENU OPTION\n");
            }
        } while(intMenuSelection != 3);
    }
    
    /**
     * This method takes a hand object created in main and populates it with
     * cards by using the generateHand() method. It creates a scanner object
     * to get user input. It validates that input and loops until the user
     * enters valid input. Then it checks that input against the cards in
     * the computer player's hand by invoking another hand method. It uses an
     * if/else statement to display a "You win!" or "You lose!" message, then
     * it always displays the computer's hand. This method is called in a loop
     * in main until the user selects "Exit"
     * @param hand 
     */
    public static void playGame(Hand hand) {
        hand.generateHand();
        
        String strInput;
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        System.out.print("Please guess a card: ");
        
        strInput = scrKeyboard.nextLine();
        
        while(hand.validateCard(strInput) == false) {
            System.out.print("Please enter a valid card name: ");
            strInput = scrKeyboard.nextLine();
        }
        
        if(hand.searchHand(strInput) == true) {
            System.out.println("That card was in my hand.");
        }
        else {
            System.out.println("That card was not in my hand.");
        }
        
        System.out.println("These were the cards in my hand:");
        
        for(int i = 0 ; i < hand.returnHandSize() ; i++) {
            System.out.print(hand.getSingleCard(i));
            System.out.print("\t");
        }
        
        System.out.println("");
    }
}
