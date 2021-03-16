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
    private Rate _winningRate;
    
    
    
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
    
    public void betChips(double chipsToBet) throws IllegalArgumentException{
        
        if(chipsToBet > this._fund) {
            throw new IllegalArgumentException("Insufficent Fund.");
        }else if( chipsToBet <= 0){
            throw new IllegalArgumentException("Bet must be greater than 0");
        }else{
            this._fund -= chipsToBet; 
            this._bet = chipsToBet;
        }
    }
    
    /**
     * Method to calculate how much chips won.
     * plus get the bet back.
     */
    public void wonChips() {
        this._fund += (1 + this._winningRate.getRate()) * this._bet;
    
    }
    
    /**
     * Getter for _fund
     * @return 
     */
    public double getFund() {
        return _fund;
    }
   
    /**
     * Setter for _fund
     * @param _fund 
     */
    public void setFund(double _fund) {
        this._fund = _fund;
    }

    public void setWinningRate(Rate _winningRate) {
        this._winningRate = _winningRate;
    }
    
    
    
    
}
