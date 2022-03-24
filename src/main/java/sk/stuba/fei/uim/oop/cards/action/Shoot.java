package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;


import java.util.ArrayList;

public class Shoot extends ActionCard {

    public Shoot(boolean[] aimers, Player[] players, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
        this.aimers = aimers;
        this.players = players;
        this.board = board;
        this.boardDeck = boardDeck;
    }


    protected void shootPosition(int position) {
        if (this.board.get(position).getName().equals("Duck")) {
            this.board.remove(position);
            this.board.add(boardDeck.get(0));
            this.boardDeck.remove(0);
            System.out.println(this.board.get(position).getOwner().name + "'s Duck was shot on position " + (position + 1) + ".");
            this.board.get(position).getOwner().loseHealth();

        } else {
            System.out.println(this.board.get(position).getName() + " was shoot on position " + (position + 1) + ".");
        }
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
        int position = KeyboardInput.readInt("Choose position to shoot", 5) - 1;
        while (!(position >= 0 && position <= 5) || !aimers[position]) {
            position = KeyboardInput.readInt("Can't shoot there, try again!") - 1;
        }
        shootPosition(position);
        aimers[position] = false;
    }
}
