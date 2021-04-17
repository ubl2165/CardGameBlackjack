package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.enums.Rate;

/**
 * A class defines Betting token or chips and its associated actions.
 * @author Ji Li 2021 April
 */

public class Chips {
    
    /**
     * Field
     */
    
    private double chipsInPocket;
    private double bet;
    private Rate winningRate;
   
    
    /**
     * Constructor
     * @param numberOfChips 
     */
    public Chips(double numberOfChips) {
        
        this.chipsInPocket = numberOfChips;
        this.bet = 0;
            
    }

    /**
     * Method to bet chips 
     * @param chipsToBet
     * @throws IllegalArgumentException
     */
    
    public void betChips(double chipsToBet){
        

            this.chipsInPocket -= chipsToBet; 
            this.bet += chipsToBet;
    }
    
    /**
     * Method to calculate how much chips won.
     * plus get the bet back.
     */
    public void computeChips( ) {
        
        this.chipsInPocket += (1 + this.winningRate.getRate()) * this.bet;
        
        //reset the bet to zero
        this.bet = 0;
    
    }
    
    /**
     * Getter for chipsInPocket
     * @return 
     */
    public double getChipsInPocket() {
        return chipsInPocket;
    }
   

    /**
     * Setter for WinningRate 
     * @param winningRate 
     */
    public void setWinningRate(Rate winningRate) {
        this.winningRate = winningRate;
    }
    
    /**
     * Getter for bet
     * @return 
     */
    public double getBet() {
        return bet;
    }
    
    
    
    
    
}
