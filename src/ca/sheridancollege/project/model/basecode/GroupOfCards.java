/*
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * 
 * 
 */
package ca.sheridancollege.project.model.basecode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Ji Li 2021 April
 * 
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();// added initialize cards 
    private int size;//the size of the grouping
    
    
    /**
     * Constructor with size as argument
     * @param size integer type
     */
    public GroupOfCards(int size) {
        this.size = size;
    }
    
    /**
     * No-argument constructor.
     */
    public GroupOfCards() {
        
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    /**
     * A method to shuffle the elements of the cards.
     */
    public void shuffle() {
        Collections.shuffle(getCards());
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
//        return size;
            return cards.size();
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
