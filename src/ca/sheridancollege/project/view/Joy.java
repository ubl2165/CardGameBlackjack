/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import java.util.Random;

/**
 *
 * @author Ji Li
 */
public enum Joy {
    TEAR(" wipes off the sweet tears!"),
    SMILE(" grins wildly!"),
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
    
    private String getAction() {
        return this.action;
    }
    
    public static String beHappy() {
     Random randomChoice = new Random();
     
     int length = Joy.values().length;
     
     return Joy.values()[randomChoice.nextInt(length)].getAction();
}
    
}
