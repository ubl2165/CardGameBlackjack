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
 * This class defines the basic Blackjack rules, and controls the view and 
 * model class.
 *
 * @author Ji LI 2021 March
 */
public class BlackjackGame extends Game {

    /**
     * Added fields
     */
    private Deck deck = Deck.getDeck();
    private Dealer dealer = new Dealer("DEALER");
    private ArrayList<Player> players = new ArrayList<>();
    private GameUI hostess = new GameUI();

    /**
     * This constructor constructs the Blackjack with parameters.
     *
     * @param name
     * @param setOfCards : how many set of cards to play.
     * @param dealer
     * @param gamblers
     */
    BlackjackGame(String name, int setOfCards, ArrayList<Player> gamblers) {
        super(name);

        //First gamblers join the player list, then followed by dealer
        players.addAll(gamblers);
        players.add(dealer);

        //second, generating deck according to how many sets of cards to play
        generateNewDeck(setOfCards);

        //shuffle deck, and ready to play.
        deck.shuffle();

    }

    /**
     * Method to create deck for Blackjack game. Game generates new deck, not
     * the player or the deck it self. clear all the deck first.
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
     * Play the game with Blackjack rules. 1. Deal cards 2. Display every
     * player's hand. 3. Dealer conceal one card at beginning of the game. 4.
     * Every gambler play their game 5. Dealer plays out his game. 6. Declare
     * Winner
     */
    public void play() {

        //Game Start: First Each Gambler place a bet except Dealer.
        for (Player player : players) {

            if (player instanceof Gambler) {

                double bet = hostess.bettingPrompt((Gambler) (player));

                ((Gambler) player).getChips().betChips(bet);
            }

        }

        //Secondly, dealer deal cards. 
        hostess.dealCardsAnnoucement();
        dealer.deal(players);

        //Thirdly, show hands, first Dealer's hand: one card consealed
        hostess.displayConsealedHand(dealer);

        //then, all other players display hands.
        for (Player player : players) {

            if (player instanceof Gambler) {

                hostess.displayFullHand(player);

            }

        }
        
        //Fourthly, everybody starts to play out one by one, 
        //dealer is the last turn.
        for (Player player : players) {
            
            player.play();
            
            hostess.displayInterlude(200);
        }

        declareWinner();

    }

    ;

    /**
     * When the game is over, use this method to declare winning player.
     * In Blackjack game, other players at the table are of no concern each other.
     * Each player competes only against the Dealer.
     * This method will declare winner for each participating player and dealer.
     */
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
                

            }//end of first if statment

        }//end of for each loop


        System.out.println("Number of Cards left in Deck:" + this.deck.getSize());//testing only

    }//end of declarewinner

}
