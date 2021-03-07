/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author plumh
 */
public class Gambler extends Player{
    
    //fields
    private int chips = 1000;
    private Hand hand;
    
    public Gambler(String name){
        super(name);
    }
    
     /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    @Override
    public void play() {
        System.out.println("boo");
    }
    
    public void placeBet(int bet) {
        this.chips -= bet; 

    }
    
    
    
    
    
}
