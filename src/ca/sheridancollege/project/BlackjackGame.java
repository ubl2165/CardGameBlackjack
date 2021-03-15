/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Ji LI 2021
 */
public class BlackjackGame extends Game {

    private Deck _deck;
    private Dealer _dealer;
    private ArrayList<Gambler> _gamblers;

    BlackjackGame(String name,int setOfCards, Dealer dealer, ArrayList<Gambler> gamblers) {
        super(name);
        _deck = new Deck(setOfCards);
        _deck.shuffle();
        this._dealer = dealer;
        this._gamblers = gamblers;
        
        //set same deck to every player, including dealer and gamblers
        for(Gambler g : this._gamblers) {
            g.setDeck(this._deck);
        }        
        this._dealer.setDeck(this._deck);
        
        
        this.getPlayers().addAll(this._gamblers);
        this.getPlayers().add(this._dealer);
        
       
        
    }

    private void deal() {

        //according to the rule, inital two cards for each player.
        //starting from each gamblers then dealer
        for (int i = 0; i < 2; i++) {

            //rest of the gamblers get cards
            for (Gambler g : this._gamblers) {
                g._hand.addCard(this._deck.distributeCard());
            }
            
            //Dealer get first card
            this._dealer._hand.addCard(this._deck.distributeCard());
        }
        
        
    }


    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public void play() {
        deal();
        
//        Show hands
        System.out.println(this._dealer.displayConcealedHand());
       
        for(Gambler g : this._gamblers) {
            System.out.println(g.displayHand());
                    
        }
        
        System.out.println("*******************************");
        System.out.println("*******************************");
        
        for(Gambler g : this._gamblers) {
            g.play();
        }
        
        this._dealer.play();
        
        declareWinner();
      
    }

    ;

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public void declareWinner() {
        
        int max = -2;
        String winner = "";
        for(int i = 0; i < this._gamblers.size(); i++){
         if(max < _gamblers.get(i).getScore()) {
             max = _gamblers.get(i).getScore();
             winner = _gamblers.get(i).getName();
         }
        }
        
        if (max < _dealer.getScore()) {
            winner = _dealer.getName();
        }
        
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Winner is: " + winner);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }


}
