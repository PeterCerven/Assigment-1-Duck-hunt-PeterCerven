package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;


public class Aim extends ActionCard {

    public Aim(boolean[] aimers) {
        this.aimers = aimers;
    }

    @Override
    public String getName() {
        return "Aim";
    }

    @Override
    public boolean playable() {
        for (boolean b : aimers) {
            if (!b) return true;
        }
        return false;
    }


    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose position between 1 and 6", 5) - 1;
        while (!(position >= 0 && position <= 5) || aimers[position]) {
            position = KeyboardInput.readInt("Not valid position, choose another") - 1;
        }
        System.out.println(getName() + " was played on position " + (position + 1));
        aimers[position] = true;
    }


}
