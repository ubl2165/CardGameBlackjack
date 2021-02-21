/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author plumh
 */
public class BlackjackCard extends Card {

    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        TEN, JACK, QUEEN, KING
    }

//    public enum Special {
//        BACK
//    };

    /**
     * Field
     */
    private Value value;
    private Suit suit;

    /**
     * constructor
     *
     * @param value
     * @param suit
     */
    public BlackjackCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.value.toString() + " of " + this.suit.toString();
    }
}
