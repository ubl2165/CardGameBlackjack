package ca.sheridancollege.project.controller;

import ca.sheridancollege.project.model.BlackjackCard;
import ca.sheridancollege.project.model.Deck;
import ca.sheridancollege.project.model.enums.Status;
import ca.sheridancollege.project.model.enums.Rate;
import ca.sheridancollege.project.model.basecode.Game;
import ca.sheridancollege.project.model.basecode.Player;
import ca.sheridancollege.project.model.enums.Result;
import ca.sheridancollege.project.view.GameUI;
import java.util.ArrayList;

/**
 * This class defines the basic Blackjack rules, and controls the view and model
 * classes.
 *
 * @author Ji LI 
 * @version 2.0 2021 April
 */
public class BlackjackGame extends Game {

    /**
     * Fields
     */
    private Deck deck = Deck.getDeck();
    private int setOfCards;
    private Dealer dealer = new Dealer("DEALER");
    private ArrayList<Player> players = new ArrayList<>();
    private GameUI hostess = new GameUI();

    /**
     * This constructor constructs the Blackjack with parameters.
     *
     * @param name which is a String
     * @param setOfCards which is a integer to record how many set of cards to play.
     * @param dealer which is a sub class type of Player
     * @param gamblers which is a sub class type of Player's ArrayList
     */
    BlackjackGame(String name, int setOfCards, ArrayList<Player> gamblers) {
        
        super(name);

        //First gamblers join the player list, then followed by dealer
        players.addAll(gamblers);
        players.add(dealer);
       
        this.setOfCards = setOfCards;


    }

    /**
     * Method to create deck for Blackjack game. 
     * Game generates new deck, not the player or the deck it self. 
     * Clear all the cards on deck first.
     *
     * @param sets : how many set of cards to play
     */
    private void generateNewDeck(int sets) {

        //clear the deck first.
        deck.getCards().clear();

        for (int i = 0; i < sets; i++) {
            for (BlackjackCard.Value v : BlackjackCard.Value.values()) {
                for (BlackjackCard.Suit s : BlackjackCard.Suit.values()) {
                    deck.getCards().add(new BlackjackCard(v, s));
                }
            }
        }
    }

    /**
     * Play the game with Blackjack rules. 
     * After generating a new deck and shuffles the cards.
     *
     * 1. Each player places bet.
     * 2. Deal cards 
     * 3. every player starts to play out one by one
     * 4. declare winner
     * 5. re-list players
     * 6. game over if no gambler in the list
     */
    @Override
    public void play() {

        do {

            //Generating deck according to how many sets of cards to play
            generateNewDeck(setOfCards);

            //shuffle deck, and ready to play.
            deck.shuffle();

            //Game Start: First Each Gambler place a bet except Dealer.
            for (Player player : players) {

                if (player instanceof Gambler) {

                    double bet = hostess.bettingPrompt((Gambler) (player));

                    ((Gambler) player).getChips().betChips(bet);
                    
                    hostess.displayInterlude(50);
                }
            }//end of for

            //Secondly, dealer deal cards. 
            hostess.dealCardsAnnoucement();
            
            //devide the text
            hostess.displayInterlude(50);
            
            dealer.deal(players);


            //Thirdly, everybody starts to play out one by one, 
            //dealer is the last turn.
            for (Player player : players) {

                if (player instanceof Gambler) {
                    
                    //display Dealer's hand first
                    hostess.displayConsealedHand(dealer);

                }
                
                if(player != null) 
                            player.play();

                hostess.displayInterlude(50);
            }
            
            //Fourthly, declare winner for each player against dealer
            declareWinner();
            
            //re-group the player list
            reListPlayers(players);
            
            //display players stayed.
            hostess.announcePlayersOnTheTable(players);

        } while (players.size() > 1);//if only dealer in the list, out of loop
        
        // if only Dealer in the list, game over
        hostess.announceGameOver();

    }

    /**
     * When the game is over, use this method to declare winning player. 
     * In Blackjack game, other players at the table are of no concern.
     * Each player competes only against the Dealer. This method will declare
     * winner for each participating player and dealer.
     */
    @Override
    public void declareWinner() {

        Result result;

        int dealerScore;

        if (this.dealer.getStatus().equals(Status.HAND_VALUE)) {
            dealerScore = this.dealer.getHand().getHandValue();
        } else {
            dealerScore = this.dealer.getStatus().getScore();

        }

        for (Player player : players) {

            if (player instanceof Gambler) {

                int gambleerScore;

                //equals or == to testing equality of enum, I chose ==
                //Get gambler's score
                if (((Gambler) player).getStatus() == Status.HAND_VALUE) {

                    gambleerScore = player.getHand().getHandValue();

                } else {

                    gambleerScore = ((Gambler) player).getStatus().getScore();

                }

                if (dealerScore < gambleerScore) {

                    //Set winning rate for the gambler, if won by blackjack or not
                    if (((Gambler) player).getStatus().equals(Status.GAMBLER_BLACKJACK)) {

                        ((Gambler) player).getChips().setWinningRate(Rate.BLACKJACK_RATE);

                    } else {

                        ((Gambler) player).getChips().setWinningRate(Rate.REGULAR_RATE);

                    }

                    result = Result.YouWon;

                } else if (dealerScore > gambleerScore) {

                    //Set losing rate for the gambler
                    ((Gambler) player).getChips().setWinningRate(Rate.LOSING_RATE);

                    result = Result.YouLost;

                } else {

                    //Set winning rate for the gambler when it is a tie
                    ((Gambler) player).getChips().setWinningRate(Rate.PUSH_RATE);

                    result = Result.Tie;
                }
                
                
                //result is out, declare it
                hostess.declareWinner(dealer, ((Gambler) player), result);
                
                //Calculate chips depends on WinningRate
                ((Gambler) player).getChips().computeChips();

                //Displayer chips remain in the hand
                hostess.displayChipsInHand(((Gambler) player));
                
                //space the text
                hostess.displayInterlude(50);

            }//end of first if statment

        }//end of for each loop
        
        //for testing and debugging purpose mainly
        System.out.println("Number of Cards left in Deck:" + this.deck.getSize());

    }//end of declarewinner

    /**
     * Method to let go of player with zero chips, 
     * and remove player who chooses to leave the game.
     *
     * @param players which is ArrayList of Player type
     */
    public void reListPlayers(ArrayList<Player> players) {

        ArrayList<Player> brokePlayers = new ArrayList<>();
        ArrayList<Player> quitPlayers = new ArrayList<>();

        for (Player player : players) {

            if (player instanceof Gambler
                    && ((Gambler) player).getChips().getChipsInPocket() == 0) {

                hostess.announceDeparture((Gambler) player);
                brokePlayers.add(player);
            }//end of if
        }//end of for

        players.removeAll(brokePlayers);
//        System.out.println("Leaving players: " + Arrays.toString(leaving.toArray()));

        if (players.size() > 1) {
            
            hostess.announcePlayersOnTheTable(players);
            
            for (Player player : players) {

                if (player instanceof Gambler && !hostess.continuePlayingPrompt(player)) {

                    quitPlayers.add(player);
                    
                    hostess.displayInterlude(50);

                }//end of inner if

            }//end of for

            players.removeAll(quitPlayers);
        }

    }//end of reListPlayers method

}
