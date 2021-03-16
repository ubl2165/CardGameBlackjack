
package ca.sheridancollege.project.blackjack;

/**
 * An enumeration class to define score Constance.
 * @author Ji Li 2021 March
 */
public enum Status {
    DEALER_BLACKJACK(100), GAMBLER_BLACKJACK(100), DEALER_BUST(1), 
    GAMBLER_BUST(0), FACE_VALUE;
    
    private int _score;
    
    Status() {
        this._score = -1;
    }
    
    Status (int score){
        
        this._score = score;
        
    }
    
    public int getScore(){
        return this._score;
    }
    
}
