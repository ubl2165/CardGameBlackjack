package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.basecode.Card;
import ca.sheridancollege.project.model.basecode.GroupOfCards;


/**
 * Extends class GroupOfCards
 * 
 * Deck define the deck card for Blackjack game.
 * 
 * @author Ji Li 2021 March
 */
public class Deck extends GroupOfCards {
    
    /**
     * Field.
     * 
     */
    
    
    private static Deck oneAndOnly = null; //step 1: set up global object
    
    /**
     * Constructor.which is private, control the access.
     * Generating new deck according to how many set of cards to play
     * 
     * @param 
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
     * Method to remove one card from the deck to distribute to the player.
     * Works with addCard() in hand class.
     * @return Card
     */
    public Card distributeCard() {
//        this.setSize(this.getSize() - 1);
        return getCards().remove(0);
    }

}
