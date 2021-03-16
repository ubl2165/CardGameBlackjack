package ca.sheridancollege.project.blackjack;

/**
 *A class define Betting token or chips.
 * @author Ji Li
 */

public class Chips {
    

    
    
    
    /**
     * Field
     */
    
    private double _fund;
    private double _bet;
//    Rate _rate;
    
    
    
    /**
     * Constructor
     * @param numberOfChips 
     */
    public Chips(int numberOfChips) {
        
        this._fund = numberOfChips;
        this._bet = 0;
            
    }

    /**
     * Method to bet chips 
     * @param chipsToBet
     * @throws Exception 
     */
    
    public void betChips(int chipsToBet) throws Exception{
        
        if(chipsToBet < this._fund) {
            throw new IllegalArgumentException("Insufficent Fund.");
        }else{
            this._fund -= chipsToBet; 
            this._bet = chipsToBet;
        }
    }
    
    /**
     * Method to calculate how much chips won
     */
    public void wonChips(Rate winningRate) {
        this._fund += this._bet + winningRate.getRate() * this._bet;
    
    }
    
}
