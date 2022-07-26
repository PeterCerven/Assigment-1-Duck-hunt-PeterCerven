package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class WildBill extends Shoot {

    public WildBill(boolean[] aimers, Player[] players, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
        super(aimers, players, board, boardDeck);
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
        int position = KeyboardInput.readInt("Choose position between 1 and 6", 5) - 1;
        while (!(position >= 0 && position <= 5)) {
            position = KeyboardInput.readInt("Not valid position, choose another") - 1;
        }
        super.shootPosition(position);
        aimers[position] = false;

    }
}
