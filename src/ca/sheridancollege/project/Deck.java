package ca.sheridancollege.project;

import java.util.ArrayList;


/**
 * extends class GroupOfCards
 *
 * @author Ji Li
 */
public class Deck extends GroupOfCards {

    private int _setOfCards;

    public Deck(int setOfCards) {
        super(52 * setOfCards);
        this._setOfCards = setOfCards;
        cards = new ArrayList<>();
        generateNewDeck(this._setOfCards);
    }

    /**
     * Create full set of cards for blackjack.
     */
    private void generateNewDeck(int sets) {
        for (int i = 0; i < sets; i++) {
            for (BlackjackCard.Value v : BlackjackCard.Value.values()) {
                for (BlackjackCard.Suit s : BlackjackCard.Suit.values()) {
                    cards.add(new BlackjackCard(v, s));
                }
            }
        }
    }

    //Distribute card
    public Card distributeCard() {
        this.setSize(this.getSize() - 1);
        return cards.remove(0);
    }

}
