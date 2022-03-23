package sk.stuba.fei.uim.oop.cards.nonaction;

import sk.stuba.fei.uim.oop.game.Player;

public class Duck extends NonActionCard {


    public Duck(Player player) {
        this.name = "Duck";
        this.owner = player;
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
