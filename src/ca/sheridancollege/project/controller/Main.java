

package ca.sheridancollege.project.controller;

import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.view.GameUI;
import java.util.ArrayList;



/**
 * Entry class for the  project.
 * @author Ji Li
 * @version 2.0 2021 April
 */
public class Main {

    public static void main(String[] args) {

        BlackjackGame game;
        GameUI host = new GameUI();
        ArrayList<Player> list = new ArrayList<>();
        String name = "Blackjack";
        int setOfCards;
        
        
        list = host.addPlayersPrompt();
        
        setOfCards = host.setOfCardsPrompt();
        
        game = new BlackjackGame(name, setOfCards, list);
        
        game.play();


        

    }//main method

}
