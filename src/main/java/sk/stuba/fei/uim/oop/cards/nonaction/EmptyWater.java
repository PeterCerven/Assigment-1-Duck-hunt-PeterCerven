package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public class EmptyWater extends NonActionCard {


    public EmptyWater(String name, Player owner) {
        super(name, owner);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
}
