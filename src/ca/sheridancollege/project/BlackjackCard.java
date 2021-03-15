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
        HEARTS("hearts"), CLUBS("clubs"), SPADES("spades"), DIAMONDS("diamonds");
        
        private String  _suitName;
        
        Suit(String name){
            this._suitName = name;
        }
        
        public String getSuitName(){
            return this._suitName;
        }
        
    }

    public enum Value {
        ACE("ace", 1, 11), TWO("2", 2), THREE("3", 3), FOUR("4", 4), 
        FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
        TEN("10", 10), JACK("jack", 10), QUEEN("queen", 10), KING("king", 10);
        
        private String _valueName;
        private int _cardValue;
        private int _alternativeValue;
        
        Value(String name, int cardValue) {
            this._valueName = name;
            this._cardValue = cardValue;
            this._alternativeValue = -100;//for test only
        }
        
        Value(String name, int cardValue, int alternativeValue){
            
            this._valueName = name;
            this._cardValue = cardValue; 
            this._alternativeValue = alternativeValue;
      
        }

        public String getValueName() {
            return _valueName;
        }

        public int getCardValue() {
            return _cardValue;
        }

        public int getAlternativeValue() {
            return _alternativeValue;
        }
    
    }


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
        return this.value.getValueName() + " of " + this.suit.getSuitName();
    }
}
