/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
//import ca.sheridancollege.project.BlackjackCard.Suit;
//import ca.sheridancollege.project.BlackjackCard.Value;

/**
 *
 * @author plumh
 */
public class Hand extends GroupOfCards {

    private int _numberOfAce;
    private int _handValue;



    public Hand(int size) {
        super(size);

//        this._bjCards = new ArrayList<>();
        cards = new ArrayList<>();

//        cards.addAll(bjCards);

        this._handValue = 0;
        _numberOfAce = 0;
    }

    public void addCard(Card card) {
        //cards add 1
        cards.add(card);

//        if(card instanceof BlackjackCard) {
//            this._bjCards.add((BlackjackCard)card);
//        }
        //size add 1        
        this.setSize(cards.size());

        //if is a Ace ,numberOfAce add 1
        if (card instanceof BlackjackCard && ((BlackjackCard) card).getValue() == BlackjackCard.Value.ACE) {
            this._numberOfAce++;

        }

        //every time add a card, update hand value and alternative value
        computeValue();

    }

//    public void addCard(BlackjackCard card) {
//        //cards add 1
//        this._bjCards.add(card);
//
//        //size add 1        
//        this.setSize(this._bjCards.size());
//
//    }
    private void computeValue() {
        
        //set hand value to zero, otherwise there will be incorrect result.
        this._handValue = 0;

        for (int i = 0; i < cards.size(); i++) {
            if (((BlackjackCard)cards.get(i)).getValue() != BlackjackCard.Value.ACE) {
                this._handValue += ((BlackjackCard)cards.get(i)).getValue().getCardValue();
            }
        }
        
        for (int i = 0; i < this._numberOfAce; i++) {
            
            if(this._handValue + BlackjackCard.Value.ACE.getAlternativeValue() > 21) {
                this._handValue +=  BlackjackCard.Value.ACE.getCardValue();
            }else {
                this._handValue += BlackjackCard.Value.ACE.getAlternativeValue();
            }
        }

    }


    public int getHandValue() {
        return _handValue;
    }



}
