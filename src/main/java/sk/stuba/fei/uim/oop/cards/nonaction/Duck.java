package sk.stuba.fei.uim.oop.cards.nonaction;

public class Duck extends NonActionCard {
    private final String owner;
    private final String name;


    public Duck(String name) {
        this.name = "Duck " + name;
        this.owner = name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }
}
