package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.cards.nonaction.EmptyWater;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.cards.nonaction.Duck;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Player[] players;
    private int currentPlayer;
    private int roundCounter;
    private ArrayList<NonActionCard> boardDeck;
    private ArrayList<ActionCard> actionDeck;


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

    private void initializeDecks() {
        for (Player player : players) {
            for (int j = 0; j < 5; j++) {
                Duck duck = new Duck(player.name);
                this.boardDeck.add(duck);
            }
        }
        for (int k = 0; k < 5; k++){
            EmptyWater emptyWater = new EmptyWater();
            this.boardDeck.add(emptyWater);
        }

    }

    private void gameStart() {

    }
}
