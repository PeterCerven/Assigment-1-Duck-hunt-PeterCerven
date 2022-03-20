package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;


import java.util.ArrayList;

public class Shoot extends ActionCard {

    public Shoot(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck, Player[] players) {
        this.aimers = aimers;
        this.board = board;
        this.boardDeck = boardDeck;
        this.players = players;
    }

    protected void shootPosition(int position) {
        int index;
        if (this.board.get(position).getName().contains("Duck")) {
            index = findOwnerIndex(this.board.get(position).getOwner());
            this.board.remove(position);
            this.board.add(boardDeck.get(0));
            this.boardDeck.remove(0);
            System.out.println(players[index].name + "'s Duck was shot on position " + (position + 1));
            this.players[index].loseHealth();

        } else {
            System.out.println(this.board.get(position).getName() + " was shoot on position " + (position + 1));
        }
    }

    protected int findOwnerIndex(String owner) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].name.equals(owner)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String getName() {
        return "Shoot";
    }

    @Override
    public boolean playable() {
        for (boolean b : this.aimers) {
            if (b) return true;
        }
        return false;
    }

    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose position to shoot") - 1;
        while (!aimers[position]) {
            position = KeyboardInput.readInt("Can't shoot there, try again!") - 1;
        }
        shootPosition(position);
        aimers[position] = false;
    }
}
