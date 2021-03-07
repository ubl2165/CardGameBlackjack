package ca.sheridancollege.project;

/**
 * extends class GroupOfCards
 *
 * @author Ji Li
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52);
        this.generateNewDeck();
        shuffle();
    }

    /**
     * Create full set of cards for blackjack.
     */
    private void generateNewDeck() {
        for (BlackjackCard.Value v : BlackjackCard.Value.values()) {
            for (BlackjackCard.Suit s : BlackjackCard.Suit.values()) {
                this.cards.add(new BlackjackCard(v, s));
            }
        }

    }

}
