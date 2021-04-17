
package ca.sheridancollege.project.model.enums;

/**
 * An enumeration class to define score Constants.
 * @author Ji Li 2021 March
 */
public enum Status {
    DEALER_BLACKJACK(100), GAMBLER_BLACKJACK(100), DEALER_BUST(1), 
    GAMBLER_BUST(0), HAND_VALUE;
    
    private int score;
    
    Status() {
        this.score = -1;
    }
    
    Status (int score){
        
        this.score = score;
        
    }
    
    /**
     * Getter
     * @return 
     */
    public int getScore(){
        return this.score;
    }
    
}
