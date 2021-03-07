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
    private Hand hand;
    private int chips = 10000;
    
    
    
    public Dealer(String name) {
        super(name);
                
    } 
    
    @Override
    public void play() {
        System.out.println("foo");
    }
}