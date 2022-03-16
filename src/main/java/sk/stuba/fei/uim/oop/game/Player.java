package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Player extends GameBoard{
    public final String name;
    private boolean alive;
    public ArrayList<ActionCard> cardsToUse;
    private int hitPoints;

    public Player(String name){
        this.name = name;
        this.alive = true;
        this.cardsToUse = new ArrayList<>();
        hitPoints = 5;

    }

    public void loseHealth(){
        System.out.println("Player has left " + this.hitPoints + " ducks");
        hitPoints--;
    }

    public void drawCard(){
        this.cardsToUse.add(getActionDeck().get(0));
        getActionDeck().remove(0);
    }

    public void playCard(){

    }

    public void throwAwayCard(){
        int chooseCard = ZKlavesnice.readInt("Enter number of players between 1 and 3: ");
        getActionDeck().add(this.cardsToUse.get(chooseCard));
        getActionDeck().remove(chooseCard);

    }

    public boolean isAlive(){
        return this.alive = true;
    }

    public String getName() {
        return name;
    }
}
