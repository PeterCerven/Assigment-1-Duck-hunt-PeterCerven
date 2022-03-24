package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public abstract class NonActionCard {
    protected String name;
    protected Player owner;

    public NonActionCard(String name, Player owner) {
        this.name = name;
        this.owner = owner;
    }

    public abstract String getName();

    public abstract Player getOwner();
}
