package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.action.ActionCard;

import java.util.ArrayList;

public class Player {
    public final String name;
    private boolean active;
    public ArrayList<ActionCard> cardsToUse;
    private int hitPoints;

    public Player(String name){
        this.name = name;
        this.active = true;
        this.cardsToUse = new ArrayList<>();
        hitPoints = 5;
    }

    public void loseHealth(){
        System.out.println("Player has left " + this.hitPoints + " ducks");
        hitPoints--;
    }

    public void drawCard(){

    }

    public void playCard(){

    }

    public boolean isActive(){
        return active;
    }
}
