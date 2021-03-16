package ca.sheridancollege.project.blackjack;

import ca.sheridancollege.project.basecode.Player;

/**
 * @author Ji Li
 */
public class Dealer extends Player {

    /**
     * Fields.
     * _score for declare winner purpose.
     */
    private Deck _deck;
    private int _score;//for deciding winner
    protected Hand _hand;
    
    
    
    /**
     * Constructor.
     * Initial dealer's hand to zero. 
     * @param name 
     */
    public Dealer(String name) {
        super(name);
        _hand = new Hand(0);

    }

    /**
     * This method displays before the dealer's turn to play.
     * @return one card concealed 
     */
    public String displayConcealedHand() {
        return "Dealer's hand: " + this._hand.getCards().get(0).toString() + " Folded Card";

    }
    
    /**
     * This method displays the full hand of dealer when dealer playing
     * @return String of full hand 
     */
    public String displayFullHand() {

        return "Dealer's hand: " + this._hand.getCards().toString() + " Value: "
                + this._hand.getHandValue();

    }
    
    /**
     * This method check if it is Blackjack only when first two cards are dealt. 
     * @return Boolean value 
     */
    public boolean isBlackjack() {
        //return ture only player receives 21 on first and second card
        //that means one of the two card is an Ace, and count as 11 
        return this._hand.getHandValue() == 21
                && this._hand.getSize() == 2;
    }
    
    /**
     * This method check if sum of card value over 21.
     * @return Boolean value
     */
    public boolean isBust() {

        return this._hand.getHandValue() > 21;
    }

    /**
     * This method applies Dealer's rules to play in Blackjack.
     * 1. If dealer gets Blackjack at beginning, dealer gets highest score 101.
     * 2. If dealer gets bust, dealer gets 0 score, 
     * still higher than player's bust which is only -1.
     * 3. Dealer can't stop dealing until hand value reach 17 or more.
     * 
     */
    public void play() {
        System.out.println("Dealer's play -- foo");
        
        int flag;
        
        do {            
            flag = this._hand.getHandValue();
            System.out.println(displayFullHand());
            if (this.isBlackjack()) {
                System.out.println("***********Blackjack!!!***********");
                //more than player's Blackjack for casino privilege.
                this._score = 101;
            } else if (this.isBust()) {
                System.out.println("***********Bust!!!***********");

                //set gambler's bust score to -1, less than dealer's bust
                this._score = 0;
            } else if (this._hand.getHandValue() >= 17) {
                this._score = this._hand.getHandValue();
            } else {
                System.out.println("*******Hit another card************");
                System.out.println("-----------------------------------");
                this._hand.addCard(this._deck.distributeCard());
            }

        } while (flag < 17);// out of loop when flag over 17.

        System.out.println(this._score);//for test only
    }
    
    /**
     * Setter for _deck. 
     * Invoking from BlackjackGame.
     * In play() can perform hit function: add card to hand from deck.
     * @param _deck 
     */
    public void setDeck(Deck _deck) {
        this._deck = _deck;
    }

    /**
     * Getter for _score.
     * @return integer score for deciding winner.
     */
    public int getScore() {
        return _score;
    }

}
