package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;
import sk.stuba.fei.uim.oop.game.GameBoard;


import java.util.ArrayList;

public class Shoot extends ActionCard {
    boolean[] aimers;
    ArrayList<NonActionCard> board;
    ArrayList<NonActionCard> boardDeck;
    private Player[] players;

    public Shoot(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck, Player[] players) {
        this.aimers = aimers;
        this.board = board;
        this.boardDeck = boardDeck;
        this.players = players;
    }

    @Override
    public String getName() {
        return "Shoot";
    }

    @Override
    public boolean playable() {
        for(boolean b : this.aimers) {
            if (b) return true;
        }
        return false;
    }

    public int findOwnerIndex(String owner){
        for (int i = 0; i < players.length; i++){
            if (players[i].name.equals(owner)) {
                return i;
            }
        }
        return -1;
    }

    public void killDuck(int position){
        int index;
        if (this.board.get(position).getName().startsWith("Duck")) {
            index = findOwnerIndex(this.board.get(position).getOwner());
            boardDeck.add(board.get(position));
            board.remove(position);
            board.add(boardDeck.get(0));
            boardDeck.remove(0);
            players[index].loseHealth();

        }
        aimers[position] = false;
    }


    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose position") - 1;
        while (!aimers[position]){
            position = KeyboardInput.readInt("Choose another one") - 1;
        }
        killDuck(position);
    }
}
