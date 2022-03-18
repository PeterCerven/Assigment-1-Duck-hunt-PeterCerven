package sk.stuba.fei.uim.oop.cards.action;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Aim extends ActionCard{


    @Override
    public String getName() {
        return "Aim";
    }

    @Override
    public void action(ArrayList<NonActionCard> boardDeck, boolean[] aimers,
                       ArrayList<NonActionCard> board,
                       Player player) {
        int position = KeyboardInput.readInt("Choose postition between 1 and 6");
        aimers[position] = true;
    }


}
