package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.basecode.Card;

/**
 *  This class defines the value and suit of the Blackjack card
 * @author Ji Li 2021 March
 */
public class BlackjackCard extends Card {
    
    /**
     * enumeration class Suit, with name of lowercase.
     */
    public enum Suit {
        HEARTS("hearts"), CLUBS("clubs"), SPADES("spades"), DIAMONDS("diamonds");

        private String suitName;

        Suit(String name) {
            this.suitName = name;
        }

        public String getSuitName() {
            return this.suitName;
        }

    }
    
    /**
     * enumeration class Value, declare the name, face values.
     * For ACE card, declare an alternative value 11.
     */
    public enum Value {
        ACE("ace", 1, 11), TWO("2", 2), THREE("3", 3), FOUR("4", 4),
        FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
        TEN("10", 10), JACK("jack", 10), QUEEN("queen", 10), KING("king", 10);

        private String valueName;
        private int cardValue;
        private int alternativeValue;

        Value(String name, int cardValue) {
            this.valueName = name;
            this.cardValue = cardValue;
            this.alternativeValue = -100;//for test and debug only
        }

        Value(String name, int cardValue, int alternativeValue) {

            this.valueName = name;
            this.cardValue = cardValue;
            this.alternativeValue = alternativeValue;

        }

        public String getValueName() {
            return valueName;
        }

        public int getCardValue() {
            return cardValue;
        }

        public int getAlternativeValue() {
            return alternativeValue;
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
    
    
    /**
     * Getter for enumeration Value
     * @return 
     */
    public Value getValue() {
        return value;
    }

    
    /**
     * 
     * @return format String 
     */
    @Override
    public String toString() {
        return this.value.getValueName() + " of " + this.suit.getSuitName();
    }
}
