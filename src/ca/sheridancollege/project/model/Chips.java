package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.enums.Rate;

/**
 *A class define Betting token or chips.
 * @author Ji Li
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
        
//        if(chipsToBet > this.chipsInPocket) {
//            throw new IllegalArgumentException("Insufficent Fund.");
//        }else if( chipsToBet <= 0){
//            throw new IllegalArgumentException("Bet must be greater than 0");
//        }else{
//            this.chipsInPocket -= chipsToBet; 
//            this.bet = chipsToBet;
//        }

            this.chipsInPocket -= chipsToBet; 
            this.bet += chipsToBet;
    }
    
    /**
     * Method to calculate how much chips won.
     * plus get the bet back.
     */
    public void computeChips( ) {
        this.chipsInPocket += (1 + this.winningRate.getRate()) * this.bet;
    
    }
    
    /**
     * Getter for chipsInPocket
     * @return 
     */
    public double getChipsInPocket() {
        return chipsInPocket;
    }
   
    /**
     * Setter for chipsInPocket
     * @param chipsInPocket 
     */
    public void setChipsInPocket(double chipsInPocket) {
        this.chipsInPocket = chipsInPocket;
    }

    public void setWinningRate(Rate winningRate) {
        this.winningRate = winningRate;
    }

    public double getBet() {
        return bet;
    }
    
    
    
    
    
}
