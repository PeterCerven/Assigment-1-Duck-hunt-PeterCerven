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
