package ca.sheridancollege.project.blackjack;

import ca.sheridancollege.project.basecode.Card;
import ca.sheridancollege.project.basecode.GroupOfCards;
import java.util.ArrayList;

/**
 * A class for cards on hand
 * @author Ji Li 2021 March
 */
public class Hand extends GroupOfCards {

    /**
     * Fields.
     * _numberOfAce for compute
     */
    private int _numberOfAce;
    private int _handValue;


    /**
     * Constructor
     * @param size 
     */
    public Hand(int size) {
        super(size);



//        cards.addAll(bjCards);

        this._handValue = 0;
        _numberOfAce = 0;
    }
    
    /**
     * Method to add card to hand from deck.
     * Working with distributeCard() in Deck class.
     * Each time a card added, automatically compute the hand value.
     * @param card 
     */
    public void addCard(Card card) {
        //cards add 1
        getCards().add(card);

        //size add 1        
        this.setSize(getCards().size());

        //if is a Ace ,numberOfAce add 1
        if (card instanceof BlackjackCard && ((BlackjackCard) card).getValue() == BlackjackCard.Value.ACE) {
            this._numberOfAce++;

        }

        //every time add a card, update hand value and alternative value
        computeValue();

    }

    /**
     * Method to calculate the hand's value according to Blackjack game rule.
     */
    private void computeValue() {
        
        //First, set hand value to zero, otherwise there will be incorrect result.
        this._handValue = 0;
        
        //Secondly, sum up all the non-ACE cards' value
        for (int i = 0; i < getCards().size(); i++) {
            if (((BlackjackCard)getCards().get(i)).getValue() != BlackjackCard.Value.ACE) {
                this._handValue += ((BlackjackCard)getCards().get(i)).getValue().getCardValue();
            }
        }
        
        //Finally, add Ace value accordingly
        for (int i = 0; i < this._numberOfAce; i++) {
            
            if(this._handValue + BlackjackCard.Value.ACE.getAlternativeValue() > 21) {
                this._handValue +=  BlackjackCard.Value.ACE.getCardValue();
            }else {
                this._handValue += BlackjackCard.Value.ACE.getAlternativeValue();
            }
        }

    }

    /**
     * Getter for hand value.
     * @return 
     */
    public int getHandValue() {
        return _handValue;
    }



}
