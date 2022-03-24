package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;

import java.util.ArrayList;

public class DuckMarch extends ActionCard {

    public DuckMarch(ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
        this.board = board;
        this.boardDeck = boardDeck;
    }

    @Override
    public String getName() {
        return "DuckMarch";
    }

    @Override
    public boolean playable() {
        return true;
    }


    @Override
    public void action() {
        boardDeck.add(board.get(0));
        board.remove(0);
        board.add(boardDeck.get(0));
        boardDeck.remove(0);
        System.out.println(getName() + " was played.");
    }
}
