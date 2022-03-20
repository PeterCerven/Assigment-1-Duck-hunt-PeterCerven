package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class WildBill extends Shoot {

    public WildBill(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck, Player[] players) {
        super(aimers, board, boardDeck, players);
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
        int position = KeyboardInput.readInt("Choose position between 1 and 6") - 1;
        shootPosition(position);
        aimers[position] = false;

    }
}
