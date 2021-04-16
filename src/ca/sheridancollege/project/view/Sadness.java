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
public enum Sadness {
    TEAR(" sheds off the bitter tears!"),
    SMILE(" smiles a miserable smile!"),
    STUMP(" stumps loudly!"),
    BURY(" buries the face in the hands!"),
    CURSE(" makes an obscene gesture!"),
    CLENCH(" clenchs fists angrily!"),
    BITE(" bites the lips. "),
    DARKEN(" darkens with disappointments!");

    private String feeling;

    Sadness(String action) {

        this.feeling = action;
    }

    private String getFeeling() {
        return this.feeling;
    }

    public static String feelingDown() {
        Random randomChoice = new Random();

        int length = Joy.values().length;

        return Sadness.values()[randomChoice.nextInt(length)].getFeeling();
    }
}
