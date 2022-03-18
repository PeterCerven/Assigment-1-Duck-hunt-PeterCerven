package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.*;
import sk.stuba.fei.uim.oop.cards.nonaction.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class GameBoard {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Player[] players;
    private int currentPlayer;
    private ArrayList<NonActionCard> boardDeck;
    private ArrayList<ActionCard> actionDeck;
    private ArrayList<NonActionCard> board;
    private int[] usableCards;
    private boolean[] aimers;
    private int chooseCard;


    public GameBoard() {
        System.out.println("Welcome to DUCK INVASION");
        int numberPlayers = KeyboardInput.readInt("Enter number of players between 2 and 6");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(KeyboardInput.readString("Enter PLAYER " + (i + 1) + " name"));
        }
        this.currentPlayer = 0;
        boardDeck = new ArrayList<>();
        actionDeck = new ArrayList<>();
        board = new ArrayList<>();
        aimers = new boolean[6];
        usableCards = new int[3];
        this.initializeDecks();
        this.initializeBoard();
        this.initializeHands();
        this.gameStart();
    }

    public ArrayList<ActionCard> getActionDeck() {
        return actionDeck;
    }


    private void initializeDecks() {
        //filling deck of non action cards
        for (Player player : players) {
            Duck duck = new Duck(player.name);
            this.boardDeck.addAll(Collections.nCopies(5, duck));
        }
        EmptyWater emptyWater = new EmptyWater();
        this.boardDeck.addAll(Collections.nCopies(5, emptyWater));
        Collections.shuffle(this.boardDeck);

        //filing deck of action cards
        Aim aim = new Aim();
        this.actionDeck.addAll(Collections.nCopies(10, aim));
        Shoot shoot = new Shoot();
        this.actionDeck.addAll(Collections.nCopies(12, shoot));
        WildBill wildBill = new WildBill();
        this.actionDeck.addAll(Collections.nCopies(2, wildBill));
        DuckMarch duckMarch = new DuckMarch();
        this.actionDeck.addAll(Collections.nCopies(6, duckMarch));
        Scatter scatter = new Scatter();
        this.actionDeck.addAll(Collections.nCopies(2, scatter));
        TurboDuck turboDuck = new TurboDuck();
        this.actionDeck.add(turboDuck);
        DuckDance duckDance = new DuckDance();
        this.actionDeck.add(duckDance);
        Collections.shuffle(this.actionDeck);
    }

    public void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            this.board.add(this.boardDeck.get(i));
        }
        this.boardDeck.subList(0, 6).clear();
    }

    private void initializeHands() {
        for (Player player : players) {
            for (int i = 0; i < 3; i++) {
                player.cardsToUse.add(this.actionDeck.get(0));
                this.actionDeck.remove(0);
            }
        }
    }

    private void gameStart() {
        System.out.println("Game has started!\n");
        while (playersLeft() > 1) {
            Arrays.fill(usableCards, 0);
            boardPrint();
            System.out.println("\nThis is " + this.players[currentPlayer].name + " turn and his cards are");
            for (int i = 0; i < 3; i++) {
                if (this.players[currentPlayer].cardsToUse.get(i).playable(this.aimers)) {
                    System.out.println((i + 1) + " " + this.players[currentPlayer].cardsToUse.get(i).getName());
                    usableCards[i] = i + 1;

                } else {
                    System.out.println(ANSI_RED + (i + 1) + " " + this.players[currentPlayer].cardsToUse.get(i)
                            .getName() + ANSI_RESET);
                }
            }
            if (Arrays.stream(usableCards).sum() > 0) {
                chooseCard = KeyboardInput.readInt("Choose card, any card can use") - 1;
                while (!contains(usableCards, chooseCard)) {
                    chooseCard = KeyboardInput.readInt("Choose another one") - 1;
                }
                players[currentPlayer].playCard(chooseCard, this.aimers, this.board, this.boardDeck,
                        players[currentPlayer]);
            } else {
                chooseCard = KeyboardInput.readInt("Choose card, any card to throw") - 1;
                players[currentPlayer].throwAwayCard(chooseCard, actionDeck);
            }
            actionDeck.add(players[currentPlayer].cardsToUse.get(chooseCard));
            players[currentPlayer].cardsToUse.remove(chooseCard);


            players[currentPlayer].drawCard(this.actionDeck.get(0));
            this.actionDeck.remove(0);

            nextPlayer();


        }
        System.out.println("The winner is " + winner());
    }

    private int playersLeft() {
        int counter = 0;
        for (Player player : players) {
            if (player.isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    private boolean contains(int[] usableCards, int chosenNumber) {
        for (int usableCard : usableCards) {
            if (usableCard == chosenNumber) {
                return true;
            }
        }
        return false;
    }

    private void boardPrint() {
        System.out.println("Board is:");
        for (int i = 0; i < board.size(); i++) {
            System.out.print((i+1) + " " + aimers[i]);
            System.out.println(" " + board.get(i).getName());
        }
    }

    private void nextPlayer() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
        if (this.players[this.currentPlayer].isAlive()) {
            this.currentPlayer++;
            this.currentPlayer %= this.players.length;
        }
    }

    private String winner() {
        for (Player player : players) {
            if (player.isAlive()) {
                return player.name;
            }
        }
        return null;
    }
}
