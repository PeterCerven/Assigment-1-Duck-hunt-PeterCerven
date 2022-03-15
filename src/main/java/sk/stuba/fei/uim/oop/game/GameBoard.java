package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.*;
import sk.stuba.fei.uim.oop.cards.nonaction.EmptyWater;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.cards.nonaction.Duck;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;
import sk.stuba.fei.uim.oop.game.DeckCards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    private Player[] players;
    private int currentPlayer;
    private int roundCounter;
    public ArrayList<NonActionCard> boardDeck;
    public ArrayList<ActionCard> actionDeck;


    public GameBoard() {
        System.out.println("Welcome to DUCK INVASION");
        int numberPlayers = ZKlavesnice.readInt("Enter number of players between 2 and 6: ");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + " name:"));
        }
        boardDeck = new ArrayList<NonActionCard>();
        this.initializeDecks();
        this.gameStart();

    }

    public void fillNonActionDeck(int numCards, NonActionCard card){

        for (int i = 0; i < numCards; i++){
            this.boardDeck.add(card);
        }
    }
    public void fillActionDeck(int numCards, ActionCard card){
        for (int i = 0; i < numCards; i++){
            this.actionDeck.add(card);
        }
    }

    private void initializeDecks() {
        for (Player player : players) {
            Duck duck = new Duck(player.name);
            fillNonActionDeck(5, duck);
        }
        EmptyWater emptyWater = new EmptyWater();
        fillNonActionDeck(5, emptyWater);

        Collections.shuffle(this.boardDeck);


        Aim aim = new Aim();
        fillActionDeck(10, aim);

        Shoot shoot = new Shoot();
        fillActionDeck(12, shoot);

        WildBill wildBill = new WildBill();
        fillActionDeck(2, wildBill);

        DuckMarch duckMarch = new DuckMarch();
        fillActionDeck(6, duckMarch);

        Scatter scatter = new Scatter();
        fillActionDeck(2, scatter);

        TurboDuck turboDuck = new TurboDuck();
        this.actionDeck.add(turboDuck);

        DuckDance duckDance = new DuckDance();
        this.actionDeck.add(duckDance);

        Collections.shuffle(this.actionDeck);


    }

    private void gameStart() {

    }
}
