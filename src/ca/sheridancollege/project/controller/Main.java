/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.controller;

import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.view.GameUI;
import java.util.ArrayList;



/**
 *
 * @author Ji Li
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
