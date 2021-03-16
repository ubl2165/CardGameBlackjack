package ca.sheridancollege.project.blackjack;

/**
 *An enumeration to define Blackjack Winning Rate
 * @author Ji Li 2021 March
 */
public enum Rate {
    
    BLACKJACK_RATE(1.5), REGULAR_RATE(1.0), LOSING_RATE(1.0);
    
    private double _rate;
    
    Rate(double rate) {
    
        this._rate = rate;
    }

    public double getRate() {
        return _rate;
    }
    
    
}
