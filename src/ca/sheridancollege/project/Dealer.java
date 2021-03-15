/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * @author plumh
 */
public class Dealer extends Player {

    //fields
    private Deck _deck;
    private int _score;//for deciding winner
    protected Hand _hand;
    private int chips = 1000;

    public Dealer(String name) {
        super(name);
        _hand = new Hand(0);

    }

    //show the first in the hand after inital dealing
    public String displayConcealedHand() {
        return "Dealer's hand: " + this._hand.cards.get(0).toString() + " Folded Card";

    }

    public String displayFullHand() {

        return "Dealer's hand: " + this._hand.cards.toString() + " Value: "
                + this._hand.getHandValue();

    }

    public boolean isBlackjack() {
        //return ture only player receives 21 on first and second card
        //that means one of the two card is an Ace, and count as 11 
        return this._hand.getHandValue() == 21
                && this._hand.getSize() == 2;
    }

    public boolean isBust() {

        //return true only if computeValue > 21, 
        //becasuse alternative value always be equal or greater. 
        return this._hand.getHandValue() > 21;
    }

    @Override
    public void play() {
        System.out.println("Dealer's play -- foo");
        
        
        do{
            System.out.println(displayFullHand());
        if (this.isBlackjack()) {
            System.out.println("***********Blackjack!!!***********");
            //more than player's Blackjack for casino privilege.
            this._score = 101; 
        } else if (this.isBust()) {
            System.out.println("***********Bust!!!***********");
            
            //set gambler's bust score to -1, less than dealer's bust
            this._score = 0;
        } else if(this._hand.getHandValue() >= 17){
            this._score = this._hand.getHandValue();
        }else{
            System.out.println("*******Hit another card************");
            System.out.println("-----------------------------------");
            this._hand.addCard(this._deck.distributeCard());
        }
        
        
        }while(this._hand.getHandValue() < 17);
        
        System.out.println(this._score);
    }

    public void setDeck(Deck _deck) {
        this._deck = _deck;
    }

    public Hand getHand() {
        return _hand;
    }

    public int getChips() {
        return chips;
    }

    public void setHand(Hand hand) {
        this._hand = hand;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getScore() {
        return _score;
    }
    
    
    
}
