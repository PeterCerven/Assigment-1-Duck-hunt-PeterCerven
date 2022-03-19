package sk.stuba.fei.uim.oop.cards.nonaction;

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
    public String getOwner() {
        return null;
    }
}
