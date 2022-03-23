package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public abstract class NonActionCard {
    protected String name;
    protected Player owner;

    public abstract String getName();

    public abstract Player getOwner();

}
