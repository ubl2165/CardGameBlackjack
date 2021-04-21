/*
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project.model.basecode;

import ca.sheridancollege.project.model.BlackjackRules;
import ca.sheridancollege.project.model.Hand;

/**
 * A class that models each Player in the game. 
 * Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Ji Li 2021 April
 */
public abstract class Player {
//public abstract class Player implements BlackjackRules{

    private String name; //the unique name for this player
    private Hand hand;//represent the card in each player's hand

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand(0);
    }
    
    /**
     * Getter for hand 
     * @return  hand the Hand Type
     */
    public Hand getHand() {
        return hand;
    }

    
    /**
     * Overriding toString method to return the player's name.
     * @return 
     */
    @Override
    public String toString () {
    
        return name;
    
    }

    
    
    /**
     * Getter for name
     * @return the player name
     */
    public String getName() {
        return name;
    }

    
//     /**
//     * This method check if it is Blackjack only when first two cards are dealt.
//     *
//     * @return true if is blackjack.
//     */
//    @Override
//    public boolean isBlackjack() {
//        //return ture only player receives 21 on first and second card
//        //that means one of the two card is an Ace, and count as 11 
//        return this.hand.getHandValue() == 21
//                && this.hand.getSize() == 2;
//    }
//
//    /**
//     * This method check if sum of card value over 21.
//     *
//     * @return true if bust.
//     */
//    @Override
//    public boolean isBust() {
//
//        return this.hand.getHandValue() > 21;
//    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
