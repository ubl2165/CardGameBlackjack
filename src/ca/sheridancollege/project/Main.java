/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Arrays;

/**
 *
 * @author plumh
 */
public class Main {
    public static void main(String[] args){
        //create a blackjack game
        Game game = new Blackjack("Blackjack");
        
        //create players
        Player dealer = new Dealer("Dealer");
        Player gambler = new Gambler("Jack");
        //Add players to the player list
        game.getPlayers().add(dealer);
        game.getPlayers().add(gambler);
        
        //create a new deck
        GroupOfCards deck = new Deck(); 
        
        System.out.println(Arrays.toString(deck.getCards().toArray()));
        
    }
    
}
