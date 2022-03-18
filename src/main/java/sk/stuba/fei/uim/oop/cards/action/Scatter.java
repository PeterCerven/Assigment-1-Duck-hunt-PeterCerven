package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Scatter extends ActionCard {
    @Override
    public String getName() {
        return "Scatter";
    }

    @Override
    public boolean playable(boolean[] aimers) {
        return true;
    }


    @Override
    public void action(boolean[] aimers,
                       ArrayList<NonActionCard> board,
                       ArrayList<NonActionCard> boardDeck,
                       Player player) {
        Collections.shuffle(board);
    }
}
