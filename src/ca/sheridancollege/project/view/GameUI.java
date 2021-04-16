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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the view part of the MVC model. It is in charge of the
 * user prompting and user data input.
 *
 * @author Ji Li
 */
public class GameUI {

    /**
     * Fields
     */
    private Scanner input;
    private Validator validator;

    public GameUI() {

        input = new Scanner(System.in);
        validator = new Validator();
    }

    public ArrayList<Player> addPlayersPrompt() {

        ArrayList<Player> gamblers = new ArrayList<>();
        char answer;

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

            System.out.println("Another player? Yes/No");

            answer = input.nextLine().toUpperCase().charAt(0);

        } while (answer == 'Y');

        return gamblers;
    }

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

    public void dealCardsAnnoucement() {

        System.out.println("Betting is over. \n Dealer deals cards.");
        System.out.println("-----------------------------");
    }

    public void displayFullHand(Player player) {
        System.out.println(player.getName() + "'s hand: " + player.getHand().getCards().toString());
        System.out.println("Value: " + player.getHand().getHandValue());
        System.out.println("-----------------------------");
    }

    public void displayConsealedHand(Dealer dealer) {

        System.out.println("Dealer's hand: "
                + dealer.getHand().getCards().get(0).toString() + " Folded Card");
        System.out.println("-----------------------------");

    }

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
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                break;
            case YouLost:
                System.out.println("############################");
                System.out.println("Dealer won");
                System.out.println(gambler.getName() + Sadness.feelingDown());
                System.out.println("############################");
                break;
            case Tie:
                System.out.println("===============================");
                System.out.println("It is a Push(Tie), everybody wins.");
                System.out.println("===============================");

        }

    }//end of declareWinner

    public void displayChipsInHand(Gambler gambler) {

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(gambler.getName() + " remaining chips are : "
                + gambler.getChips().getChipsInPocket());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    public void displayPlaySceneTitle(Player player) {

        System.out.println();
        System.out.printf("***---%s's play ---***\n", player.getName());

    }

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

    public int gameChoicePrompt() {
        int choice = 0;

        System.out.println("Hit or Stand?\n1. Hit\n2. stand");

        boolean tryAgain = true;
        while (tryAgain) {
            try {
                String in = input.nextLine();
                if (validator.isNotEmptyOrNull(in)
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
        }
        return choice;
    }

    public int doubleDownPrompt(double bet, double fund, Gambler gambler) {

        int choice = 0;

        if (bet > fund) {

            System.out.printf("%s's bet is %.1f \n", gambler.getName(), bet);
            System.out.printf("%s's remaining chips are: %.1f\n", gambler.getName(), fund);
            System.out.println("Sorry, Not enough chips to do double down.");

        } else {

            System.out.println("Double down? ");

            System.out.println("Double the initial bet, but you have to hit one and only one more card.");

            System.out.println("1. Yes\n2. No");

            boolean tryAgain = true;
            while (tryAgain) {
                try {
                    String in = input.nextLine();
                    if (validator.isNotEmptyOrNull(in)
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
            }

        }

        return choice;
    }

    public void displayDealerResult(Status status, Dealer dealer) {

        switch (status) {

            case DEALER_BLACKJACK:
                System.out.println("***********Dealer got a Blackjack!!!***********");
                break;
            case DEALER_BUST:
                System.out.println("***********Dealer got a Bust!!!***********");
                break;
            case HAND_VALUE:
                System.out.printf("***********Dealer's hand: %d. He can not hit anymore.***********\n", dealer.getHand().getHandValue());

        }
    }

    public void displayDealerHittingCard(Dealer dealer) {

        System.out.printf("*******Dealer's hand: %d, less than 17************\n", dealer.getHand().getHandValue());
        System.out.println("*******He has to hit another card************");
        displayInterlude(100);

    }

    public void displayInterlude(int timeInMilliSecond) {

        int timeToWait = 10; //

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

    }

}
