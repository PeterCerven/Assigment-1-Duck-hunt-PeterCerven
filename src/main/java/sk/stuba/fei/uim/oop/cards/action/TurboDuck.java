package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class TurboDuck extends ActionCard {

    public TurboDuck( ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck) {
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
        int position = KeyboardInput.readInt("Choose position:", 5) - 1;
        while (!(position >= 0 && position <= 5) || !board.get(position).getName().contains("Duck")) {
            position = KeyboardInput.readInt("Choose another position:") - 1;
        }
        boardDeck.add(0, board.get(position));
        board.remove(position);
        board.add(0, boardDeck.get(0));
        System.out.println(getName() + " was played on position " + (position + 1));
    }
}
