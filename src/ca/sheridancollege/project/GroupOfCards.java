/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

import ca.sheridancollege.project.BlackjackCard.Suit;
import ca.sheridancollege.project.BlackjackCard.Value;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Ji Li Feb 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    public ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        generateCards();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Create full set of cards.
     */
    private void generateCards() {
        for (Value v : Value.values()) {
            for (Suit s : Suit.values()) {
                this.cards.add(new BlackjackCard(v, s));
            }
        }

    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
