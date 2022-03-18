package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;
import java.util.Collections;

public class DuckDance extends ActionCard {


    @Override
    public String getName() {
        return "DuckDance";
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
        boardDeck.addAll(board);
        board.clear();
        Collections.shuffle(boardDeck);
        for (int i = 0; i < 6; i++) {
            board.add(boardDeck.get(i));
        }
        boardDeck.subList(0, 6).clear();
    }

}
