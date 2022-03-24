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

    private final Player[] players;
    private int currentPlayer;
    private int roundCounter;
    private final ArrayList<NonActionCard> boardDeck;
    private final ArrayList<ActionCard> actionDeck;
    private final ArrayList<NonActionCard> board;
    private final int[] usableCards;
    private final boolean[] aimers;


    public GameBoard() {
        roundCounter = 0;
        this.currentPlayer = 0;
        boardDeck = new ArrayList<>();
        board = new ArrayList<>();
        aimers = new boolean[6];
        usableCards = new int[3];
        actionDeck = new ArrayList<>();
        System.out.println("Welcome to DUCK HUNT!!!");

        int numberPlayers = KeyboardInput.readInt("Enter the number of players between 2 and 6",
                5);
        while (!(numberPlayers > 1 && numberPlayers < 7)) {
            numberPlayers = KeyboardInput.readInt("Between 2 and 6!", 5);
        }
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(KeyboardInput.readString("Enter PLAYER " + (i + 1) + " name"),
                    actionDeck);
        }
        initializeDecks();
        initializeBoard();
        initializeHands();
        gameStart();
    }


    private void initializeDecks() {
        //filling deck of non action cards
        for (Player player : players) {
            Duck duck = new Duck("Duck", player);
            this.boardDeck.addAll(Collections.nCopies(5, duck));
        }
        Player emptyPlayer = new Player("Empty", actionDeck);
        EmptyWater emptyWater = new EmptyWater("Water", emptyPlayer);
        this.boardDeck.addAll(Collections.nCopies(5, emptyWater));
        Collections.shuffle(boardDeck);

        //filing deck of action cards
        Aim aim = new Aim(aimers);
        this.actionDeck.addAll(Collections.nCopies(10, aim));
        Shoot shoot = new Shoot(aimers, players, board, boardDeck);
        this.actionDeck.addAll(Collections.nCopies(12, shoot));
        WildBill wildBill = new WildBill(aimers, board, boardDeck, players);
        this.actionDeck.addAll(Collections.nCopies(2, wildBill));
        DuckMarch duckMarch = new DuckMarch(board, boardDeck);
        this.actionDeck.addAll(Collections.nCopies(6, duckMarch));
        Scatter scatter = new Scatter(board);
        this.actionDeck.addAll(Collections.nCopies(2, scatter));
        TurboDuck turboDuck = new TurboDuck(board, boardDeck);
        this.actionDeck.add(turboDuck);
        DuckDance duckDance = new DuckDance(board, boardDeck);
        this.actionDeck.add(duckDance);
        Collections.shuffle(actionDeck);
    }

    private void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            this.board.add(this.boardDeck.get(i));
        }
        this.boardDeck.subList(0, 6).clear();
    }

    private void initializeHands() {
        for (Player player : players) {
            for (int i = 0; i < 3; i++) {
                player.cardsToUse.add(actionDeck.get(0));
                actionDeck.remove(0);
            }
        }
    }

    private void gameStart() {
        int chooseCard;
        System.out.println("Game has started!\n");
        while (playersLeft() > 1) {
            System.out.println("-------------------Round " + (roundCounter + 1) + "---------------------");
            boardPrint();
            System.out.println("\nThis is " + players[currentPlayer].name + "'s turn and his/her cards are:");
            //checking and printing usable cards and printing with red color unusable ones
            usableCardsPrint();
            //deciding if playing a card or throwing a card
            if (Arrays.stream(usableCards).sum() > 0) {
                chooseCard = KeyboardInput.readInt("Choose card to play");
                while (!contains(usableCards, chooseCard) || !(chooseCard >= 1 && chooseCard <= 3)) {
                    chooseCard = KeyboardInput.readInt("Not valid card, choose another");
                }
                //playing a card
                players[currentPlayer].playCard(chooseCard);
                //needed if player kills himself
                if (!players[currentPlayer].isAlive()) {
                    roundCounter = nextPlayer();
                    continue;
                }
                actionDeck.add(players[currentPlayer].cardsToUse.get(chooseCard - 1));
                players[currentPlayer].cardsToUse.remove(chooseCard - 1);
            } else {
                //throwing a card
                chooseCard = KeyboardInput.readInt("Choose card to throw away");
                while (!(chooseCard >= 1 && chooseCard <= 3)) {
                    chooseCard = KeyboardInput.readInt("Not valid, choose another");
                }
                players[currentPlayer].throwAwayCard(chooseCard - 1);
            }

            //drawing a card from deck
            players[currentPlayer].drawCard(actionDeck.get(0));
            actionDeck.remove(0);
            roundCounter = nextPlayer();

        }
        System.out.println("\nThe winner is " + winner() + "!");
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
        System.out.println("Board:");
        for (int i = 0; i < board.size(); i++) {
            if (aimers[i]) {
                System.out.print(ANSI_RED + (i + 1) + ". aimed");
                System.out.println(" " + board.get(i).getOwner().name + " " + board.get(i).getName() + ANSI_RESET);
            } else {
                System.out.print((i + 1) + ". not aimed");
                System.out.println(" " + board.get(i).getOwner().name + " " + board.get(i).getName());
            }
        }
    }

    private void usableCardsPrint() {
        for (int i = 0; i < 3; i++) {
            if (players[currentPlayer].cardsToUse.get(i).playable()) {
                System.out.println((i + 1) + ". - " + players[currentPlayer].cardsToUse.get(i).getName());
                usableCards[i] = i + 1;

            } else {
                System.out.println(ANSI_RED + (i + 1) + ". - " + players[currentPlayer].cardsToUse.get(i)
                        .getName() + ANSI_RESET);
                usableCards[i] = 0;
            }
        }
    }

    private int nextPlayer() {
        this.currentPlayer++;
        if (this.currentPlayer == players.length) {
            roundCounter++;
        }
        this.currentPlayer %= players.length;
        while (!players[currentPlayer].isAlive()) {
            currentPlayer++;
            if (currentPlayer == players.length) {
                roundCounter++;
            }
            this.currentPlayer %= players.length;
        }
        return roundCounter;
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
