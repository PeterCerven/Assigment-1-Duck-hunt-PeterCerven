package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Player{
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

    public void drawCard(ActionCard card){
        this.cardsToUse.add(card);
    }

    public void playCard(){

    }

    public void throwAwayCard(GameBoard gameBoard){
        int chooseCard = ZKlavesnice.readInt("Enter number of players between 1 and 3: ");
        gameBoard.getActionDeck().add(this.cardsToUse.get(chooseCard));
        gameBoard.getActionDeck().remove(chooseCard);

    }

    public void dead(){
        this.alive = false;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public String getName() {
        return name;
    }
}
