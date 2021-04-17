package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.basecode.Card;
import ca.sheridancollege.project.model.basecode.GroupOfCards;


/**
 * Extends class GroupOfCards, this is a singleton class that defines the deck 
 * cards for Blackjack game.
 * 
 * @author Ji Li 2021 April
 */
public class Deck extends GroupOfCards {
    
    /**
     * Field.
     * 
     */   
    private static Deck oneAndOnly = null; //step 1: set up global object
    
    /**
     * Constructor.which is private, control the access.
     */
    private Deck() { //step 2: make constructor private
        
    }
    
    
    /**
     * 
     * @return Deck instance which is one and only
     */
    public static Deck getDeck() {//step 3. a getter method
        if(oneAndOnly == null) {
            
            oneAndOnly = new Deck();
        }
        return oneAndOnly;
    
    }



    /**
     * Method to remove one card from top of the deck to distribute to the player.
     * Works with addCard() in hand class.
     * @return Card
     */
    public Card distributeCard() {

        return getCards().remove(0);
    }

}
