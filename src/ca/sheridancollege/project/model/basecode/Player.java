/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project.model.basecode;

import ca.sheridancollege.project.model.BlackjackRules;
import ca.sheridancollege.project.model.Deck;
import ca.sheridancollege.project.model.Hand;

/**
 * A class that models each Player in the game. 
 * Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player implements BlackjackRules{

    private String name; //the unique name for this player
    private Hand hand;
//    public Deck deck = Deck.getDeck();

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand(0);
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    



//    public Deck getDeck() {
//        return _deck;
//    }
//
//    public void setDeck(Deck _deck) {
//        this._deck = _deck;
//    }
//    
    

    
    
    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
     /**
     * This method check if it is Blackjack only when first two cards are dealt.
     *
     * @return Boolean value
     */
    @Override
    public boolean isBlackjack() {
        //return ture only player receives 21 on first and second card
        //that means one of the two card is an Ace, and count as 11 
        return this.hand.getHandValue() == 21
                && this.hand.getSize() == 2;
    }

    /**
     * This method check if sum of card value over 21.
     *
     * @return Boolean value
     */
    @Override
    public boolean isBust() {

        return this.hand.getHandValue() > 21;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
