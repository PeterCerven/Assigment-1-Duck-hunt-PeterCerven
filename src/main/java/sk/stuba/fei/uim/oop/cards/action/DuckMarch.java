package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;

public class DuckMarch extends ActionCard {


    @Override
    public String getName() {
        return "DuckMarch";
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
        boardDeck.add(board.get(0));
        board.remove(0);
        board.add(boardDeck.get(0));
        boardDeck.remove(0);
    }
}
