package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class defines the basic Blackjack rules
 *
 * @author Ji LI 2021 March
 */
public class BlackjackGame extends Game {

    /**
     * Added fields
     */
    private Deck _deck;
    private Dealer _dealer;
    private ArrayList<Gambler> _gamblers;

    /**
     * This constructor constructs the Blackjack with parameters.
     *
     * @param name
     * @param setOfCards : how many set of cards to play.
     * @param dealer
     * @param gamblers
     */
    BlackjackGame(String name, int setOfCards, Dealer dealer, ArrayList<Gambler> gamblers) {
        super(name);
        _deck = new Deck(setOfCards);
        _deck.shuffle();
        this._dealer = dealer;
        this._gamblers = gamblers;

        //Assign same deck to every player, including dealer and gamblers
        for (Gambler g : this._gamblers) {
            g.setDeck(this._deck);
        }
        this._dealer.setDeck(this._deck);

        //Assign dealer and gamblers to the player list
        this.getPlayers().addAll(this._gamblers);
        this.getPlayers().add(this._dealer);

    }

    /**
     * Method for card dealing. There are two passes to initialize the game.
     * each pass distributes one card from first player to dealer Each pass
     * distributes one card from the deck.
     */
    private void deal() {

        //according to the rule, inital two cards for each player.
        //starting from each gamblers then dealer
        for (int i = 0; i < 2; i++) {

            //first, the gamblers get cards
            for (Gambler g : this._gamblers) {
                g._hand.addCard(this._deck.distributeCard());
            }

            //Dealer gets card
            this._dealer._hand.addCard(this._deck.distributeCard());
        }

    }

    /**
     * Play the game with Blackjack rules. 1. Deal cards 2. Display every
     * player's hand. 3. Dealer conceal one card at beginning of the game. 4.
     * Every gambler play their game 5. Dealer plays out his game. 6. Declare
     * Winner
     */
    public void play() {
        deal();

//        Show hands
        System.out.println(this._dealer.displayConcealedHand());

        for (Gambler g : this._gamblers) {
            System.out.println(g.displayHand());

        }

        System.out.println("*******************************");
        System.out.println("*******************************");

        for (Gambler g : this._gamblers) {
            g.play();
        }

        this._dealer.play();

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

                
        for (int i = 0; i < this._gamblers.size(); i++) {
            

            String winner = this._dealer.getName();

            if (this._dealer.getScore() < _gamblers.get(i).getScore()) {
                
                winner = _gamblers.get(i).getName();
            }
            
            //Display winner
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println(_gamblers.get(i).getName() + " vs. Dealer\n"
                    + "Winner is: " + winner);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        }

    }

}
