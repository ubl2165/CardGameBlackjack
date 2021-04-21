package ca.sheridancollege.project.controller;


import ca.sheridancollege.project.model.enums.Status;
import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.view.GameUI;
import java.util.ArrayList;

/**
 * A class to represents the Blackjack game's dealer.
 *
 * It interacts with the View, that is why it is considered a controller
 *
 * @author Ji LI
 * @version 2.0 2021 April
 */
public class Dealer extends Player {

    /**
     * Fields.
     */
    private Status status;//for deciding winner
    private GameUI hostess = new GameUI();

    /**
     * Constructor.
     *
     * @param name String type
     */
    public Dealer(String name) {
        super(name);
    }

    /**
     * Method for card dealing. There are two passes to initialize the game.
     * Each pass adds one card to each player(including dealer). Each pass
     * distributes one card from the deck. Before each initial dealing, call
     * washHand method to clear old data from last game. dealer deal cards:
     * single responsibility.
     *
     * @param players which are the all player list
     */
    public void deal(ArrayList<Player> players) {

        //First clear all cards on player's hand, set numberOfAces back to 0
        for (Player player : players) {

            //clear cards in the hand
            player.getHand().washHand();
        }

        //according to the rule, inital two cards for each player.
        //starting from each gamblers then dealer
        for (int i = 0; i < 2; i++) {

            for (Player player : players) {

                player.getHand().addCard();
            }

        }

    }

    /**
     * This method applies Dealer's rules to play in Blackjack. 1. If dealer
     * gets Blackjack at beginning, dealer gets highest score 101. 2. If dealer
     * gets bust, dealer gets 0 score, with Casino privilege, it is still higher
     * than player's bust which is only -1. 3. Dealer can't stop dealing until
     * hand value reach 17 or more.
     *
     */
    @Override
    public void play() {

        hostess.displayPlaySceneTitle(this);

        hostess.displayFullHand(this);

        //first check if it is a Blackjack
        if (this.getHand().isBlackjack()) {

            this.status = Status.DEALER_BLACKJACK;

        } else {

            int flag;
            do {

                flag = this.getHand().getHandValue();

                if (this.getHand().isBust()) {

                    //set deal's bust score to 0, more than gamlber's bust
                    this.status = Status.DEALER_BUST;

                } else if (this.getHand().getHandValue() >= 17) {

                    this.status = Status.HAND_VALUE;
                } else {

                    hostess.displayDealerHittingCard(this);

                    //hit a card
                    this.getHand().addCard();

                    hostess.displayFullHand(this);
                }

            } while (flag < 17);// out of loop when flag over 17.
        }

        hostess.displayDealerResult(this.getStatus(), this);

    }

    /**
     * Getter for status.
     *
     * @return integer score for deciding winner.
     */
    public Status getStatus() {
        return status;
    }

}
