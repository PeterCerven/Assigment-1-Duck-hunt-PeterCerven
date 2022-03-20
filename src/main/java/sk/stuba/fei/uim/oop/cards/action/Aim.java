package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.utility.KeyboardInput;


public class Aim extends ActionCard {
    boolean[] aimers;


    public Aim(boolean[] aimers) {
        this.aimers = aimers;
    }

    @Override
    public String getName() {
        return "Aim";
    }

    @Override
    public boolean playable() {
        for(boolean b : aimers) {
            if (!b) return true;
        }
        return false;
    }


    @Override
    public void action() {
        int position = KeyboardInput.readInt("Choose position between 1 and 6") - 1;
        while(aimers[position]){
            position = KeyboardInput.readInt("Not valid position, choose another") - 1;
        }
        System.out.println(getName() + " was played on position " + (position + 1));
        aimers[position] = true;
    }


}
