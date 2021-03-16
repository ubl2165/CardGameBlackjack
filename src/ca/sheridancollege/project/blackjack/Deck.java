package ca.sheridancollege.project.blackjack;

import ca.sheridancollege.project.basecode.Card;
import ca.sheridancollege.project.basecode.GroupOfCards;
import java.util.ArrayList;

/**
 * Extends class GroupOfCards
 * Deck define the deck card for Blackjack game.
 * 
 * @author Ji Li 2021 March
 */
public class Deck extends GroupOfCards {
    
    /**
     * Field.
     * _setOfCards: how many set of cards to play the game.
     */
    
    private int _setOfCards;
    
    /**
     * Constructor.
     * Generating new deck according to how many set of cards to play
     * 
     * @param setOfCards 
     */
    public Deck(int setOfCards) {
        super(52 * setOfCards);
        
        this._setOfCards = setOfCards;

        generateNewDeck(this._setOfCards);
    }

    /**
     * Method to create deck for Blackjack game.
     * 
     * @param sets : how many set of cards to play 
     */

    private void generateNewDeck(int sets) {
        for (int i = 0; i < sets; i++) {
            for (BlackjackCard.Value v : BlackjackCard.Value.values()) {
                for (BlackjackCard.Suit s : BlackjackCard.Suit.values()) {
                    getCards().add(new BlackjackCard(v, s));
                }
            }
        }
    }

    /**
     * Method to remove one card from the deck to distribute to the player.
     * Works with addCard() in hand class.
     * @return Card
     */
    public Card distributeCard() {
        this.setSize(this.getSize() - 1);
        return getCards().remove(0);
    }

}
