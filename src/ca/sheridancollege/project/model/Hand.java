package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.basecode.Card;
import ca.sheridancollege.project.model.basecode.GroupOfCards;


/**
 * A class representing cards on hand.
 * @author Ji Li 2021 March
 */
public class Hand extends GroupOfCards implements BlackjackRules {

    /**
     * Fields.
     * 
     */
    private int numberOfAce;
    private int handValue;
    private Deck deck;


    /**
     * Constructor
     * @param size 
     */
    public Hand(int size) {
        super(size);
        deck = Deck.getDeck();
        this.handValue = 0;
        numberOfAce = 0;
    }
    
    /**
     * Method to add card to hand from deck.
     * Working with distributeCard() in Deck class.
     * Each time a card added, automatically compute the hand value.
     * 
     */
    public void addCard() {
        
        Card card = deck.distributeCard();
        //cards add 1
        getCards().add(card);

        //size add 1        
        this.setSize(getCards().size());

        //if is a Ace ,numberOfAce add 1
        if (card instanceof BlackjackCard && ((BlackjackCard) card).getValue() == BlackjackCard.Value.ACE) {
            this.numberOfAce++;
        }

        //every time add a card, update hand value and alternative value
        computeValue();

    }

    /**
     * Method to calculate the hand's value according to Blackjack game rule.
     */
    private void computeValue() {
        
        //First, set hand value to zero, otherwise there will be incorrect result.
        this.handValue = 0;
        
        //Secondly, sum up all the non-ACE cards' value
        for (int i = 0; i < getCards().size(); i++) {
            if (((BlackjackCard)getCards().get(i)).getValue() != BlackjackCard.Value.ACE) {
                this.handValue += ((BlackjackCard)getCards().get(i)).getValue().getCardValue();
            }
        }
        
        //Finally, add Ace value accordingly
        for (int i = 0; i < this.numberOfAce; i++) {
            
            if(this.handValue + BlackjackCard.Value.ACE.getAlternativeValue() > 21) {
                this.handValue +=  BlackjackCard.Value.ACE.getCardValue();
            }else {
                this.handValue += BlackjackCard.Value.ACE.getAlternativeValue();
            }
        }

    }

    /**
     * Getter for hand value.
     * @return 
     */
    public int getHandValue() {
        return handValue;
    }
    
    
    /**
     * A method to clear all cards in hand and set number of Aces back to zero.
     */
    public void washHand(){
    
        getCards().clear();
        this.numberOfAce = 0;
        this.handValue = 0;
        this.setSize(0);
    
    }
    
    /**
     * This method check if it is Blackjack only when first two cards are dealt.
     *
     * @return true if is blackjack.
     */
    @Override
    public boolean isBlackjack() {
        //return ture only player receives 21 on first and second card
        //that means one of the two card is an Ace, and count as 11 
        return this.handValue == 21
                && this.getSize() == 2;
    }

    /**
     * This method check if sum of card value over 21.
     *
     * @return true if bust.
     */
    @Override
    public boolean isBust() {

        return this.handValue > 21;
    }



}
