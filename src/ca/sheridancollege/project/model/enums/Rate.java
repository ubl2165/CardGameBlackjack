package ca.sheridancollege.project.model.enums;

/**
 * An enumeration to define Blackjack Winning Rate.
 * used in calculating the chips after game.
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
