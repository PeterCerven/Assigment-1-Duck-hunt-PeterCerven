package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class TurboDuck extends ActionCard {
    boolean[] aimers;
    ArrayList<NonActionCard> board;
    ArrayList<NonActionCard> boardDeck;

    public TurboDuck(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
        this.aimers = aimers;
        this.board = board;
        this.boardDeck = boardDeck;
    }

    @Override
    public String getName() {
        return "TurboDuck";
    }

    @Override
    public boolean playable() {
        return true;
    }


    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose postition:") - 1;
        boardDeck.add(0, board.get(position));
        board.remove(position);
        board.add(0, boardDeck.get(0));
        System.out.println(getName() + " was played o position " + (position + 1));
    }
}
