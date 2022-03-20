package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class WildBill extends ActionCard{

    public WildBill(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck, Player[] players) {
        this.aimers = aimers;
        this.board = board;
        this.boardDeck = boardDeck;
        this.players = players;
    }

    @Override
    public String getName() {
        return "WildBill";
    }

    @Override
    public boolean playable() {
        return true;
    }


    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose postition between 1 and 6") - 1;
        shootPosition(position);
        aimers[position] = false;

    }
}
