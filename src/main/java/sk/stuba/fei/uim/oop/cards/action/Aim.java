package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Aim extends ActionCard {


    @Override
    public String getName() {
        return "Aim";
    }

    @Override
    public boolean playable(boolean[] aimers) {
        for(boolean b : aimers) {
            if (!b) return true;
        }
        return false;
    }


    @Override
    public void action(boolean[] aimers,
                       ArrayList<NonActionCard> board,
                       ArrayList<NonActionCard> boardDeck,
                       Player player) {
        int position = KeyboardInput.readInt("Choose postition between 1 and 6");
        aimers[position] = true;
    }


}
