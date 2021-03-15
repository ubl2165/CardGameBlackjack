/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author plumh
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Ask how many setofcards to be used for play
        System.out.println("How many sets of cards to play?");
        int setOfCards = input.nextInt();

        //remove newline charactor
        input.nextLine();

        //Ask Dealer's name
        System.out.println("what is the dealer's name?");
        String dealerName = input.nextLine();
        Dealer dealer = new Dealer(dealerName);

        //Ask Gambler's name
        ArrayList<Gambler> gamblers = new ArrayList<>();
        char answer;
        do {
            System.out.println("what is player's name?");
            
            Gambler gambler = new Gambler(input.nextLine());
            gamblers.add(gambler);

            System.out.println("Another player? Yes/No");

            answer = input.nextLine().toUpperCase().charAt(0);

        } while (answer == 'Y');
        
        BlackjackGame game = new BlackjackGame("Blackjack", setOfCards, 
                dealer, gamblers);
        
        game.play();
        
        

    }//main method

}
