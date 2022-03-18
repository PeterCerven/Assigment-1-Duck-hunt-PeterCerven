package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class TurboDuck extends ActionCard {
    @Override
    public String getName() {
        return "TurboDuck";
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
        int position = KeyboardInput.readInt("Choose postition:") - 1;
        while (!aimers[position]){
            position = KeyboardInput.readInt("Choose another one:") - 1;
        }
        boardDeck.add(0, board.get(position));
        board.remove(position);
        board.add(0, boardDeck.get(0));
    }
}
