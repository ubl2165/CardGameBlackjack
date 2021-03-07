package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * extends class GroupOfCards
 *
 * @author Ji Li
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52);
        cards = new ArrayList<>();
        generateNewDeck();
    }

    /**
     * Create full set of cards for blackjack.
     */
    private void generateNewDeck() {
        for (BlackjackCard.Value v : BlackjackCard.Value.values()) {
            for (BlackjackCard.Suit s : BlackjackCard.Suit.values()) {
                cards.add(new BlackjackCard(v, s));
            }
        }

    }

}
