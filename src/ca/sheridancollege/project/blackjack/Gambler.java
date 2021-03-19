package ca.sheridancollege.project.blackjack;

import ca.sheridancollege.project.enums.Status;
import ca.sheridancollege.project.basecode.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * This class to define Gambler class, the actual player of Blackjack Game.
 * Extents Player class.
 *
 * @author Ji Li 2021 March
 */
public class Gambler extends Player {

    /**
     * Fields.
     */
//    protected Hand _hand;
//    private Deck _deck;
    private Status _status;//for deciding winner
    private Chips _chips;
    private Scanner input;

    /**
     * Constructor
     *
     * @param name
     *
     */
    public Gambler(String name) {
        super(name);
//        this._hand = new Hand(0);
        _chips = new Chips(10);

        input = new Scanner(System.in);
//        this._chips.setFund(10);//set initial fund to 10 chips 

    }

//    /**
//     * This method check if it is Blackjack only when first two cards are dealt.
//     *
//     * @return Boolean value
//     */
//    public boolean isBlackjack() {
//        //return ture only player receives 21 on first and second card
//        //that means one of the two card is an Ace, and count as 11 
//        return this._hand.getHandValue() == 21
//                && this._hand.getSize() == 2;
//    }
//
//    /**
//     * This method check if sum of card value over 21.
//     *
//     * @return Boolean value
//     */
//    public boolean isBust() {
//
//        return this._hand.getHandValue() > 21;
//    }

    /**
     * This method displays the full hand of gambler
     *
     * @return String of full hand
     */
    public String displayHand() {
        return this.getName() + "'s hand: "
                + this.getHand().getCards().toString() + " Value: "
                + this.getHand().getHandValue();
    }

    /**
     * This method applies Player(gambler)'s rules to play in Blackjack. 1. If
     * gambler gets Blackjack at beginning, player gets score 100 only less than
     * the dealer's blackjack score. 2. If gambler gets bust, gambler gets -1
     * score, less than dealer's bust. 3. Gambler can choose hit or stand when
     * is not bust.
     *
     */
    @Override
    public void play() {

        System.out.printf("***---Player %s's play ---***\n", this.getName());

        //Place a bet
        //Use exception to catch illegal input
        boolean isValid = true;
        while (isValid) {

            System.out.println("Your current fund is: " + _chips.getFund());
            System.out.println("How many chips do you want to put down?");

            try {

                double bet = input.nextDouble();

                this._chips.betChips(bet);

                //if no exception caught, isValid is false, out of while loop
                isValid = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            } catch (InputMismatchException ex) {

                System.out.println("Please enter a whole number");

                //line remover
                input.nextLine();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(this.displayHand());

        //When receive the first two cards
        if (this.isBlackjack()) {
            System.out.println("***********Blackjack!!!***********");
            this._status = Status.GAMBLER_BLACKJACK;
        } else if (this.isBust()) {
            System.out.println("***********Bust!!!***********");

            //set dealer's bust score to 0, greater than player's bust
            this._status = Status.GAMBLER_BUST;
        } else {
            int answer = 0;

            do {

                System.out.println("Hit or Stand?\n1. Hit\n2. stand");

                isValid = true;
                while (isValid) {
                    try {

                        answer = input.nextInt();
                        isValid = false;
                    } catch (InputMismatchException ex) {

                        System.out.println("Please enter a whole number.");
                        //line remover
                        input.nextLine();
                    }
                }

                switch (answer) {

                    case 1:
                        this.getHand().addCard(this.getDeck().distributeCard());

                        if (this.isBust()) {
                            System.out.println("**********Bust!!!**************");
                            this._status = Status.GAMBLER_BUST;
                        } else {
                            this._status = Status.FACE_VALUE;
                        }

                        break;

                    case 2:
                        this._status = Status.FACE_VALUE;
                        break;

                    default:
                        System.out.println("Invalid input.");

                }

                System.out.println(this.displayHand());

            } while (!this.isBust() && answer != 2);

        }

        System.out.println(this._status);//for test only

    }

//    /**
//     * Setter for _deck. Invoking from BlackjackGame. In play() can perform hit
//     * function: add card to hand from deck.
//     *
//     * @param _deck
//     */
//    public void setDeck(Deck _deck) {
//
//        this._deck = _deck;
//    }

    /**
     * Getter for _status.
     *
     * @return integer score for deciding winner.
     */
    public Status getStatus() {
        return _status;
    }

    /**
     * Getter for _chips
     *
     * @return Chips
     */
    public Chips getChips() {
        return _chips;
    }

}
