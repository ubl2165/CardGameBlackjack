/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import ca.sheridancollege.project.controller.Dealer;
import ca.sheridancollege.project.controller.Gambler;
import ca.sheridancollege.project.model.Validator;
import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.model.enums.Result;
import ca.sheridancollege.project.model.enums.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the User Interface (view) part of the MVC model. 
 * It is in charge of the user input prompting and narratives.
 *
 * @author Ji Li
 * @version 2.0 2021 April
 */
public class GameUI {

    /**
     * Fields
     */
    private Scanner input;
    private Validator validator;
    
    /**
     * Constructor
     */
    public GameUI() {

        input = new Scanner(System.in);
        validator = new Validator();
    }

    /**
     * A method to prompt new player
     * @return ArrayList of new Player
     */
    public ArrayList<Player> addPlayersPrompt() {

        ArrayList<Player> gamblers = new ArrayList<>();
        boolean answer;

        do {
            System.out.println("what is new player's name?");

            boolean tryAgain = true;

            while (tryAgain) {

                String name = input.nextLine();

                try {
                    if (validator.isNotEmptyOrNull(name)
                            && validator.isValidLength(name, 2)
                            && validator.isValidFullName(name)
                            && validator.isUniqueName(name, gamblers)) {

                        Player newPlayer = new Gambler(name);
                        gamblers.add(newPlayer);

                        System.out.println(name + " joins the table. ");
                        tryAgain = false;

                    }

                } catch (IllegalArgumentException ex) {

                    System.err.println("Error: " + ex.getMessage());
                    System.out.println("Try again.");

                } catch (Exception ex) {

                    System.err.println("Error: " + ex.getMessage());
                    System.out.println("Try again.");
                }

            }

            System.out.println("Another player?");
            System.out.println("1. Yes\n2. No");

            answer = choseYes();

        } while (answer);

        return gamblers;
    }
    
    /**
     * A method to prompt betting
     * @param gambler
     * @return chips to bet which is a double type
     */
    public double bettingPrompt(Gambler gambler) {

        double bet = 0;

        boolean tryAgain = true;

        System.out.printf("***---Player %s's Betting ---***\n", gambler.getName());

        //Place a bet
        //Use exceptions to catch illegal input
        while (tryAgain) {

            System.out.println("Your current fund is: "
                    + gambler.getChips().getChipsInPocket());

            System.out.println("How many chips do you want to put down?");
            String in = input.nextLine();

            try {

                if (validator.isNotEmptyOrNull(in)
                        && validator.isValidDouble(in)
                        && validator.isValidBetting(Double.parseDouble(in), gambler)) {

                    bet = Double.parseDouble(in);

                    System.out.println(gambler.getName() + " bets " + bet + " chips.");
                    tryAgain = false;
                }
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: " + ex.getMessage());

            } catch (InputMismatchException ex) {

                System.err.println("Error: Please enter a number");

            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        return bet;
    }

    /**
     * A method to prompt how many set of cards to play. 
     * @return sets of card integer type
     */
    public int setOfCardsPrompt() {

        int sets = 1;
        boolean tryAgain = true;

        while (tryAgain) {

            System.out.println("How many sets of cards to play? Choose 1 to 6.");

            String in = input.nextLine();

            try {

                if (validator.isNotEmptyOrNull(in)
                        && validator.isValidInteger(in)
                        && validator.isInTheRange(Integer.parseInt(in), 1, 6)) {

                    sets = Integer.parseInt(in);

                    System.out.println("You choose " + sets + " set of cards.");

                    tryAgain = false;
                }
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: " + ex.getMessage());

            } catch (InputMismatchException ex) {

                System.err.println("Error: Please enter a number");
//
//                //line remover
//                input.nextLine();
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        return sets;
    }//end of setOfCardsPrompt method

    /**
     * A method to print the dealing card narrative.
     */
    public void dealCardsAnnoucement() {

        System.out.println("Betting is over. \n Dealer deals cards.");
        System.out.println("-----------------------------");
    }

    /**
     * A method to display the full hand with value.
     * @param player 
     */
    public void displayFullHand(Player player) {
        System.out.println(player.getName() + "'s hand: " + player.getHand().getCards().toString());
        System.out.println("Value: " + player.getHand().getHandValue());
        
    }

    /**
     * A method to display Dealer's one card concealed hand.
     * @param dealer 
     */
    public void displayConsealedHand(Dealer dealer) {

        System.out.println("Dealer's hand: "
                + dealer.getHand().getCards().get(0).toString() + " Folded Card");
        

    }

    /**
     * A method to declare the winner according to result.
     * @param dealer
     * @param gambler
     * @param result 
     */
    public void declareWinner(Dealer dealer, Gambler gambler, Result result) {

        System.out.println("\n-------------------------------");

        System.out.printf("DEALER vs. %s\n", gambler.getName());
        displayFullHand(dealer);
        displayFullHand(gambler);
        System.out.println("---------------------------------");

        switch (result) {

            case YouWon:
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("Winner is: " + gambler.getName());
                System.out.println(gambler.getName() + Joy.beHappy());
                System.out.println();
                break;
            case YouLost:
                System.out.println("############################");
                System.out.println("Dealer won");
                System.out.println(gambler.getName() + Sadness.feelingDown());
                System.out.println();
                break;
            case Tie:
                System.out.println("===============================");
                System.out.println("It is a Push(Tie), everybody wins.");
                System.out.println();

        }

    }//end of declareWinner

    /**
     * A method to display how many chips left in the gambler's hand.
     * @param gambler 
     */
    public void displayChipsInHand(Gambler gambler) {

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(gambler.getName() + " remaining chips are : "
                + gambler.getChips().getChipsInPocket());


    }

    /**
     * A method to print out title of which player start to play.
     * @param player 
     */
    public void displayPlaySceneTitle(Player player) {

        System.out.println();
        System.out.printf("***---%s's play ---***\n", player.getName());

    }

    /**
     * A method to display the result of each game according to the 
     * Status enumeration.
     * @param status
     * @param player 
     */
    public void displayGamblerResult(Status status, Player player) {

        switch (status) {

            case GAMBLER_BLACKJACK:
                System.out.println("***********Wow, Blackjack!!!***********");
                System.out.println(player.getName() + Joy.beHappy());
                break;
            case GAMBLER_BUST:
                System.out.println("***********Dang! Bust!!!***********");
                System.out.println(player.getName() + Sadness.feelingDown());
                break;
            case HAND_VALUE:
                System.out.printf("***********Happy with %d. ***********\n", player.getHand().getHandValue());
                System.out.println(player.getName() + Joy.beHappy());
                break;
        }

    }

    /**
     * A method to prompt gambler to choose between hit and stand.
     * @return 
     */
    public boolean gameChoicePrompt() {

        System.out.println("Hit or Stand?");
        System.out.println("1. Hit\n2. Stand");

        boolean choice = choseYes();

        return choice;
    }

    /**
     * A method to prompt the User to bet double down.
     * @param bet
     * @param fund
     * @param gambler
     * @return 
     */
    public boolean doubleDownPrompt(double bet, double fund, Gambler gambler) {

        boolean choice;

        if (bet > fund) {

            System.out.printf("%s's bet is %.1f \n", gambler.getName(), bet);
            System.out.printf("%s's remaining chips are: %.1f\n", gambler.getName(), fund);
            System.out.println("Sorry, Not enough chips to do double down.");
            choice = false;

        } else {

            System.out.println("Double down? ");

            System.out.println("Double the initial bet, but you have to hit one "
                    + "and only one more card.");
            System.out.println("1. Yes\n2. No");
            choice = choseYes();
        }

        return choice;
    }

    /**
     * A method to display dealer's playing result.
     * @param status
     * @param dealer 
     */
    public void displayDealerResult(Status status, Dealer dealer) {

        switch (status) {

            case DEALER_BLACKJACK:
                System.out.println("***********Dealer got a Blackjack!!!***********");
                break;
            case DEALER_BUST:
                System.out.println("***********Dealer got a Bust!!!***********");
                break;
            case HAND_VALUE:
                System.out.printf("***********Dealer's hand: %d. He can not hit "
                        + "anymore.***********\n", dealer.getHand().getHandValue());

        }
    }

    
    /**
     * A method to dealer hitting cards until 17.
     * @param dealer 
     */
    public void displayDealerHittingCard(Dealer dealer) {

        System.out.printf("*******Dealer's hand: %d, less than 17************\n",
                 dealer.getHand().getHandValue());
        System.out.println("*******He has to hit another card************");
        

    }

    /**
     * A playful method to display gaps in between console screen.
     * @param timeInMilliSecond 
     */
    public void displayInterlude(int timeInMilliSecond) {

        int timeToWait = 10; 

        try {
            for (int i = 0; i < timeToWait; i++) {

                //timeInMilliSecond / 1000 * timeToWait =  second to wait
                Thread.sleep(timeInMilliSecond);

                System.out.println(".");

            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Eorro: " + ex.getMessage());
        }
//
//        System.out.println("Press enter to continue...");
//        try{
//            System.in.read();
//        }catch (Exception ex){
//            System.out.println("Eorro: " + ex.getMessage());
//        }
//        
    }

    /**
     * A method to say Game over.
     */
    public void announceGameOver() {

        System.out.println("Game Over");

    }

    /**
     * A method to announce a player left the game due to out of chips.
     * @param gambler 
     */
    public void announceDeparture(Gambler gambler) {

        System.out.println(gambler.getName() + " got no more chips left.");
        System.out.println(gambler.getName() + Sadness.feelingDown());
        System.out.println(gambler.getName() + " left the game.");

    }

    /**
     * A method to display players left on the game table.
     * @param players 
     */
    public void announcePlayersOnTheTable(ArrayList<Player> players) {

        System.out.println("Players stay on the table: " + Arrays.toString(players.toArray()));
        System.out.println();
        System.out.println();
    }

    /**
     * A method to prompt surviving players to continue play.
     * @param player
     * @return 
     */
    public boolean continuePlayingPrompt(Player player) {

        boolean result = false;
        if (player instanceof Gambler) {

            System.out.println(player.getName() + ", would you like to continue playing?");
            System.out.println("1. Yes\n2. No");
            result = choseYes();
        }
        
        if(player != null)
            System.out.println(result
                ? (player.getName() + " believes winning big next round.")
                : (player.getName() + " quits."));

        return result;

    }

    /**
     * A useful method to choose between two options: yes or no.
     * User can type "yes", "y" or "1" for yes, case insensitive.
     * User can input "No", "n" or "2" for no, case insensitive.
     * @return 
     */
    private boolean choseYes() {

        int choice = 0;

//        System.out.println("1. Yes\n2. No");
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                String in = input.nextLine();

                if (in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("y")) {

                    choice = 1;
                    tryAgain = false;
                } else if (in.equalsIgnoreCase("No") || in.equalsIgnoreCase("n")) {

                    choice = 2;
                    tryAgain = false;

                } else if (validator.isNotEmptyOrNull(in)
                        && validator.isValidInteger(in)
                        && validator.isInTheRange(Integer.parseInt(in), 1, 2)) {

                    choice = Integer.parseInt(in);
                    tryAgain = false;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error: " + ex.getMessage());

            } catch (InputMismatchException ex) {

                System.err.println("Error: Please enter a number");

            } catch (IllegalArgumentException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }//end of while

        return choice == 1;

    }

}
