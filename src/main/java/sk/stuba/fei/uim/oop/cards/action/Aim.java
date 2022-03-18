package sk.stuba.fei.uim.oop.cards.action;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Aim extends ActionCard{


    @Override
    public void action(ArrayList<NonActionCard> boardDeck, boolean[] aimers) {
        int position = KeyboardInput.readInt("Choose postition between 1 and 6");
        aimers[position] = true;
    }
}
