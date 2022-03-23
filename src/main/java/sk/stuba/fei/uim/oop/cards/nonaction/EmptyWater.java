package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public class EmptyWater extends NonActionCard {



    public EmptyWater(Player owner) {
        this.name = "Water";
        this.owner = owner;
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
