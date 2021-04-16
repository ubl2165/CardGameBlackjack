package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.enums.Status;
import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.view.GameUI;
import java.util.ArrayList;

/**
 * @author Ji Li
 */
public class Dealer extends Player {

    /**
     * Fields. _score for declare winner purpose.
     */
//    private Deck _deck;
//    private Deck deck = Deck.getDeck();
    private Status _status;//for deciding winner
    private GameUI hostess = new GameUI();
//    protected Hand _hand;

    /**
     * Constructor. Initial dealer's hand to zero.
     *
     * @param name
     */
    public Dealer(String name) {
        super(name);
//        _hand = new Hand(0);

    }

    
    /**
     * Method for card dealing. There are two passes to initialize the game.
     * Each pass distributes one card to each player(including dealer) dealer
     * adding to the hand.
     * Each pass distributes one card from the deck.
     * 
     * dealer deal cards: single responsibility.
     * @param deck which is the one and only instance of Deck
     * @param players which are the all player list
     */
    public void deal(Deck deck, ArrayList<Player> players) {

        //according to the rule, inital two cards for each player.
        //starting from each gamblers then dealer
        for (int i = 0; i < 2; i++) {
            
            for(Player player : players) {
            
                player.getHand().addCard(deck.distributeCard());
            }

        }

    }    
    
    
    
    /**
     * This method applies Dealer's rules to play in Blackjack. 1. If dealer
     * gets Blackjack at beginning, dealer gets highest score 101. 2. If dealer
     * gets bust, dealer gets 0 score, still higher than player's bust which is
     * only -1. 3. Dealer can't stop dealing until hand value reach 17 or more.
     *
     */
    @Override
    public void play() {

        hostess.displayPlaySceneTitle(this);
        hostess.displayFullHand(this);
     
        //first check if it is a Blackjack
        if (this.isBlackjack()) {
            
            
            this._status = Status.DEALER_BLACKJACK;

        } else {
            
            int flag;
            do {
 
                flag = this.getHand().getHandValue();
                
                if (this.isBust()) {

                    //set gambler's bust score to -1, less than dealer's bust
                    this._status = Status.DEALER_BUST;
                    
                } else if (this.getHand().getHandValue() >= 17) {
                    this._status = Status.HAND_VALUE;
                } else {

                    hostess.displayDealerHittingCard(this);
                    this.getHand().addCard(deck.distributeCard());
                }

            } while (flag < 17);// out of loop when flag over 17.
        }
        
        hostess.displayDealerResult(this.getStatus(), this);


    }

    /**
     * Getter for _status.
     *
     * @return integer score for deciding winner.
     */
    public Status getStatus() {
        return _status;
    }

}
