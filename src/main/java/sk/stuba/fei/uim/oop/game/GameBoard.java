package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.*;
import sk.stuba.fei.uim.oop.cards.nonaction.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    private Player[] players;
    private int currentPlayer;
    private int roundCounter;
    private ArrayList<NonActionCard> boardDeck;
    private ArrayList<ActionCard> actionDeck;
    private ArrayList<NonActionCard> board;

    public ArrayList<ActionCard> getActionDeck() {
        return actionDeck;
    }

    public void setActionDeck(ArrayList<ActionCard> actionDeck) {
        this.actionDeck = actionDeck;
    }

    public GameBoard() {
        System.out.println("Welcome to DUCK INVASION");
        int numberPlayers = ZKlavesnice.readInt("Enter number of players between 2 and 6: ");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + " name:"));
        }
        boardDeck = new ArrayList<NonActionCard>();
        actionDeck = new ArrayList<ActionCard>();
        board = new ArrayList<NonActionCard>();
        this.initializeDecks();
        this.initializeBoard();
        this.initializeHands();
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

        //filling deck of non action cards
        for (Player player : players) {
            Duck duck = new Duck(player.name);
            fillNonActionDeck(5, duck);
        }
        EmptyWater emptyWater = new EmptyWater();
        fillNonActionDeck(5, emptyWater);

        Collections.shuffle(this.boardDeck);

        //filing deck of action cards
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
    public void initializeBoard(){
        for (int i = 0; i < 6; i++){
            this.board.add(this.boardDeck.get(i));
        }
        this.boardDeck.subList(0, 5).clear();
    }

    private void initializeHands(){
        for (Player player: players){
            for (int i = 0; i < 3; i++) {
                player.cardsToUse.add(this.actionDeck.get(0));
                this.actionDeck.remove(0);
            }
        }
    }

    private void gameStart() {
        System.out.println("Game has started!");
        while (playersLeft() > 1){
            boardPrint();
        }

    }

    private int playersLeft(){
        int counter = 0;
        for (Player player : players){
            if (player.isAlive()){
                counter++;
            }
        }
        return  counter;
    }

    private void boardPrint(){
        for (int i = 0; i < boardDeck.size(); i++){
            System.out.println(boardDeck.get(i));
        }
    }
}
