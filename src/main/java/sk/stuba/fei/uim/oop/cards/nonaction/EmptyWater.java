package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public class EmptyWater extends NonActionCard {
    private final String name;

    public EmptyWater() {
        this.name = "Water";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Player getOwner() {
        return null;
    }
}
