package ca.sheridancollege.project.enums;

/**
 *An enumeration to define Blackjack Winning Rate
 * @author Ji Li 2021 March
 */
public enum Rate {
    
    BLACKJACK_RATE(1.5), REGULAR_RATE(1.0), PUSH_RATE(0.0), LOSING_RATE(-1.0);
    
    private double _rate;
    
    Rate(double rate) {
    
        this._rate = rate;
    }

    public double getRate() {
        return _rate;
    }
    
    
}
