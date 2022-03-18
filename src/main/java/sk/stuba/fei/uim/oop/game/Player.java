package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
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
        if (hitPoints == 0){
            dead();
        }
    }

    public void drawCard(ActionCard card){
        this.cardsToUse.add(card);
    }

    public void playCard(int cardNumber, ArrayList<NonActionCard> boardDeck, boolean[] aimers,
                         ArrayList<NonActionCard> board,
                         Player player){
       this.cardsToUse.get(cardNumber).action(boardDeck, aimers, board, player);
    }


    public void dead(){
        System.out.println("Player " + this.name + " lost all his ducks.");
        this.alive = false;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public String getName() {
        return name;
    }
}
