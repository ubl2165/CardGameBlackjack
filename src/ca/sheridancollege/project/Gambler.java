/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author plumh
 */
public class Gambler extends Player {

    //fields
//    private int chips = 100;
//    private int bet = 0;
    protected Hand _hand;
    private Deck _deck;
    private boolean _isBust;
    private boolean _isBlackjack;
    private boolean _isStand;//player's turn is over.
    private int _score;//for deciding winner
    private Scanner input = new Scanner(System.in);

    /**
     * constructor
     *
     * @param name
     *
     */
    public Gambler(String name) {
        super(name);
        this._hand = new Hand(0);

    }
//ToDo 
//    public int getChips() {
//        return chips;
//    }
//
//    public Hand getHand() {
//        return _hand;
//    }
//
//    public void setChips(int chips) {
//        this.chips = chips;
//    }
//
//    public void setHand(Hand hand) {
//        this._hand = hand;
//    }
//    public void placeBet(int bet) {
//        if(this.chips > bet)
//        {
//            this.chips -= bet;
//            this.bet = bet;
//        }else{
//            System.out.println("Insufficient fund");
//        }
//    }
    public void setDeck(Deck _deck) {

        this._deck = _deck;
    }

    public boolean isBlackjack() {
        //return ture only player receives 21 on first and second card
        //that means one of the two card is an Ace, and count as 11 
        return this._hand.getHandValue()== 21
                && this._hand.getSize() == 2;
    }

    public boolean isBust() {

        //return true only if computeValue > 21, 
        //becasuse alternative value always be equal or greater. 
        return this._hand.getHandValue()> 21;
    }

    //show all the cards in the hand
    public String displayHand() {
        return this.getName() + "'s hand: " + 
                this._hand.cards.toString() + " Value: " +
                this._hand.getHandValue();
    }

    /**
     * The method to be overridden when you subclass the Player class with your
     * specific type of Player and filled in with logic to play your game.
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
                
                if (answer == 1)
                    this._hand.addCard(this._deck.distributeCard());

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

    public int getScore() {
        return _score;
    }
    
    

}
