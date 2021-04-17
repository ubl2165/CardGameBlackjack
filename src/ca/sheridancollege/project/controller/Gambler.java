package ca.sheridancollege.project.controller;

import ca.sheridancollege.project.model.Chips;
import ca.sheridancollege.project.model.enums.Status;
import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.view.GameUI;



/**
 *
 * This class to define Gambler class, the actual player of Blackjack Game.
 * 
 * Each gambler starts with 1000 chips.
 * 
 * Extents Player class.
 *
 * @author Ji LI
 * @version 2.0 2021 April
 */
public class Gambler extends Player {

    /**
     * Fields.
     */
//    protected Hand _hand;
//    private Deck _deck;
    private Status status;//for deciding winner
    private Chips chips;
    private GameUI hostess = new GameUI();

    /**
     * Constructor
     * Set each gambler starts with 1000 chips
     * @param name
     *
     */
    public Gambler(String name) {
        super(name);
        
        //Set each gambler starts with 1000 chips
        chips = new Chips(1000);

    }
    
    /**
     * Constructor
     * @param name String
     * @param numberOfChips  Chips number
     */
    public Gambler(String name, double numberOfChips) {

        super(name);

        chips = new Chips(numberOfChips);

    }

    /**
     * This method applies Player(gambler)'s rules to play in Blackjack. 
     * 1. If gambler gets Blackjack at beginning, player gets score 100 
     * same as the dealer's blackjack score. 
     * 2. If gambler gets bust, gambler gets 0 score, less than dealer's bust 1.
     * according to casino's rule.
     * 3. Gambler can choose hit or stand when is not bust.
     * 4. After initial two cards dealt, if Gambler has enough fund, he can 
     * chooses to put double the original bets, and automatically be dealt one
     * and only one more card.
     *
     */
    @Override
    public void play() {

        hostess.displayPlaySceneTitle(this);

        hostess.displayFullHand(this);

        if (this.isBlackjack()) {

            this.status = Status.GAMBLER_BLACKJACK;
        } else if (this.isBust()) {

            //set dealer's bust score to 1, greater than player's bust
            this.status = Status.GAMBLER_BUST;
        } else {

            //check Gambler'fund, see if he got enough to do double down.
            double fund = this.getChips().getChipsInPocket();

            //check how much is the bet
            double bet = this.getChips().getBet();

            if (hostess.doubleDownPrompt(bet, fund, this) ) {

                this.chips.betChips(bet);
                this.getHand().addCard();

                if (this.isBust()) {

                    this.status = Status.GAMBLER_BUST;
                } else {
                    this.status = Status.HAND_VALUE;
                }
                hostess.displayFullHand(this);

            } else {//not double down

                int answer;

                do {

                    answer = hostess.gameChoicePrompt() ? 1: 2;

                    switch (answer) {

                        case 1:

                            this.getHand().addCard();

                            if (this.isBust()) {

                                this.status = Status.GAMBLER_BUST;
                            } else {
                                this.status = Status.HAND_VALUE;
                            }
                            hostess.displayFullHand(this);
                            break;

                        case 2:
                            this.status = Status.HAND_VALUE;
                            break;
                    }

                } while (this.getStatus() != Status.GAMBLER_BUST
                        && answer != 2);
            }

        }// end of else

        hostess.displayGamblerResult(status, this);
    }

    /**
     * Getter for status.
     *
     * @return status which is a enumeration type
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Getter for chips
     *
     * @return chips which is a Chips type.
     */
    public Chips getChips() {
        return chips;
    }
    
    /**
     * Overriding toString method with detail of chipsInPockets.
     * @return String
     */
    @Override
    public String toString () {
    
        return super.toString() + " with " + this.getChips().getChipsInPocket() 
                + " chips";
    
    }

}
