package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;

public class DuckMarch extends ActionCard{


    @Override
    public String getName() {
        return "DuckMarch";
    }

    @Override
    public void action(ArrayList<NonActionCard> boardDeck, boolean[] aimers,
                       ArrayList<NonActionCard> board,
                       Player player) {

    }
}
