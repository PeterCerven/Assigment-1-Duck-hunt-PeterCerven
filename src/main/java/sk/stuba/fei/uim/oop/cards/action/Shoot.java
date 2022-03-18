package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;


import java.util.ArrayList;

public class Shoot extends ActionCard {
    @Override
    public String getName() {
        return "Shoot";
    }

    @Override
    public boolean playable(boolean[] aimers) {
        for(boolean b : aimers) {
            if (b) return true;
        }
        return false;
    }


    @Override
    public void action(boolean[] aimers,
                       ArrayList<NonActionCard> board,
                       ArrayList<NonActionCard> boardDeck,
                       Player player) {
        int position = KeyboardInput.readInt("Choose position") - 1;
        while (!aimers[position]){
            position = KeyboardInput.readInt("Choose another one") - 1;
        }
        if (board.get(position).getName().equals("Duck")) {
            board.remove(position);
            board.add(boardDeck.get(0));
            boardDeck.remove(0);
            player.loseHealth();

        }
        aimers[position] = false;
    }
}
