package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.*;
import sk.stuba.fei.uim.oop.cards.nonaction.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;



import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    private Player[] players;
    private int currentPlayer;
    private ArrayList<NonActionCard> boardDeck;
    private ArrayList<ActionCard> actionDeck;
    private ArrayList<NonActionCard> board;
    private boolean[] aimers;


    public GameBoard() {
        System.out.println("Welcome to DUCK INVASION");
        int numberPlayers = KeyboardInput.readInt("Enter number of players between 2 and 6: ");
        this.players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            this.players[i] = new Player(KeyboardInput.readString("Enter PLAYER " + (i + 1) + " name:"));
        }
        this.currentPlayer =0;
        boardDeck = new ArrayList<>();
        actionDeck = new ArrayList<>();
        board = new ArrayList<>();
        aimers = new boolean[6];
        this.initializeDecks();
        this.initializeBoard();
        this.initializeHands();
        this.gameStart();
    }

    public ArrayList<ActionCard> getActionDeck() {
        return actionDeck;
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
        this.boardDeck.subList(0, 6).clear();
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
        System.out.println("Game has started!\n");
        while (playersLeft() > 1){
            boardPrint();
            System.out.println("\nThis is " + this.players[currentPlayer].name + " turn and his cards are:");
            for (int i = 0; i < 3; i++){
                //if (playable(this.players[currentPlayer].cardsToUse.get(i)))
                System.out.println((i + 1) + this.players[currentPlayer].cardsToUse.get(i).getName());
            }

            int chooseCard = KeyboardInput.readInt("Choose card, any card ") - 1;
            players[currentPlayer].playCard(chooseCard, this.boardDeck, this.aimers, this.board, players[currentPlayer]);
            actionDeck.add(players[currentPlayer].cardsToUse.get(chooseCard));
            players[currentPlayer].cardsToUse.remove(chooseCard);

            players[currentPlayer].drawCard(this.actionDeck.get(0));
            this.actionDeck.remove(0);

            nextPlayer();

            break;

        }
        System.out.println("The winner is " + winner());
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
        System.out.println("Board is:");
        for(int i = 0; i < board.size(); i++){
            System.out.print(aimers[i]);
            System.out.println(" " + board.get(i).getName());
        }
    }

    private void nextPlayer(){
        this.currentPlayer++;
        this.currentPlayer %= this.players.length;
        if(this.players[this.currentPlayer].isAlive()){
            this.currentPlayer++;
            this.currentPlayer %= this.players.length;
        }
    }

    private String winner(){
        for (Player player : players){
            if (player.isAlive()){
                return player.name;
            }
        }
        return null;
    }
}
