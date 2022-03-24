package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public class Duck extends NonActionCard {


    public Duck(String name, Player owner) {
        super(name, owner);
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }
}
