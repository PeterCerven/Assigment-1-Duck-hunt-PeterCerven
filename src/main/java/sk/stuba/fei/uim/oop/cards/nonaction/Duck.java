package sk.stuba.fei.uim.oop.cards.nonaction;

public class Duck extends NonActionCard{
    private String owner;
    private boolean aimed;

    public Duck(String name){
        this.owner = name;
    }

    public boolean aimed(){
        return this.aimed = true;
    }
}
