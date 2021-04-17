/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import java.util.Random;

/**
 * A enumeration class to describe the happy emotions
 * @author Ji Li
 */
public enum Joy {
    GRIN(" grins wildly!"),
    SMILE(" tries to hide the smile!"),
    JUMP(" jumps in the air!"), 
    LARGH(" larghs out loud!"),
    KISS(" throws kisses passionately!"),
    PUNCH(" punches in the air!"),
    CHUCKLE(" chuckles. "),
    BRIGHTEN(" brightens with joy!");
    
    private String action;
    
    Joy(String action) {
    
    this.action = action;
    }
    
    /**
     * Getter
     * @return 
     */
    private String getAction() {
        return this.action;
    }
    
    /**
     * 
     * @return emotion randomly
     */
    public static String beHappy() {
     Random randomChoice = new Random();
     
     int length = Joy.values().length;
     
     return Joy.values()[randomChoice.nextInt(length)].getAction();
}
    
}
