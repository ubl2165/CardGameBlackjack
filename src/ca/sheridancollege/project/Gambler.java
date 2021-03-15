package ca.sheridancollege.project;

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
    protected Hand _hand;
    private Deck _deck;
    private int _score;//for deciding winner
    private Scanner input = new Scanner(System.in);

    /**
     * Constructor
     *
     * @param name
     *
     */
    public Gambler(String name) {
        super(name);
        this._hand = new Hand(0);

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
     * This method displays the full hand of gambler
     * @return String of full hand 
     */
    public String displayHand() {
        return this.getName() + "'s hand: "
                + this._hand.getCards().toString() + " Value: "
                + this._hand.getHandValue();
    }

    /**
     * This method applies Player(gambler)'s rules to play in Blackjack.
     * 1. If gambler gets Blackjack at beginning, player gets score 100 
     * only less than the dealer's blackjack score.
     * 2. If gambler gets bust, gambler gets -1 score, less than dealer's bust. 
     * 3. Gambler can choose hit or stand when is not bust.
     * 
     */
    @Override
    public void play() {

        System.out.printf("***---Player %s's play ---***\n", this.getName());

        System.out.println(this.displayHand());

        if (this.isBlackjack()) {
            System.out.println("***********Blackjack!!!***********");
            this._score = 100;
        } else if (this.isBust()) {
            System.out.println("***********Bust!!!***********");
            this._score = -1;//set dealer's bust score to 0, greater than player's bust
        } else {
            int answer;

            do {

                System.out.println("Hit or Stand?\n1. Hit\n2. stand");

                answer = input.nextInt();

                if (answer == 1) {
                    this._hand.addCard(this._deck.distributeCard());
                }

                if (this.isBust()) {
                    System.out.println("**********Bust!!!**************");
                    this._score = -1;
                } else {
                    this._score = this._hand.getHandValue();

                }
                System.out.println(this.displayHand());

            } while (!this.isBust() && answer != 2);

        }

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
