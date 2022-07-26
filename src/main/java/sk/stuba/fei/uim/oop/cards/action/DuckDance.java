package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;

import java.util.ArrayList;
import java.util.Collections;

public class DuckDance extends ActionCard {

    public DuckDance(ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
        this.board = board;
        this.boardDeck = boardDeck;
    }

    @Override
    public String getName() {
        return "DuckDance";
    }

    @Override
    public boolean playable() {
        return true;
    }


    @Override
    public void action() {
        boardDeck.addAll(board);
        board.clear();
        Collections.shuffle(boardDeck);
        for (int i = 0; i < 6; i++) {
            board.add(boardDeck.get(i));
        }
        boardDeck.subList(0, 6).clear();
        System.out.println(getName() + " was played.");
    }

}
