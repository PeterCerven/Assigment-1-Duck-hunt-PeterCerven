package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.action.ActionCard;


import java.util.ArrayList;

public class Player {
    public String name;
    private boolean alive;
    public ArrayList<ActionCard> cardsToUse;
    private int hitPoints;
    private final ArrayList<ActionCard> actionDeck;

    public Player(String name, ArrayList<ActionCard> actionDeck) {
        this.name = name;
        this.alive = true;
        this.cardsToUse = new ArrayList<>();
        this.hitPoints = 5;
        this.actionDeck = actionDeck;

    }


    public void loseHealth() {
        hitPoints--;
        System.out.println("Number of ducks left for " + this.name + " is " + this.hitPoints + ".");
        if (hitPoints == 0) {
            dead();
        }
    }

    public void drawCard(ActionCard card) {
        this.cardsToUse.add(card);
    }

    public void playCard(int cardNumber) {
        this.cardsToUse.get(cardNumber - 1).action();
    }

    public void throwAwayCard(int chooseCard) {
        System.out.println(cardsToUse.get(chooseCard).getName() + " was thrown away.");
        this.actionDeck.add(cardsToUse.get(chooseCard));
        cardsToUse.remove(chooseCard);
    }


    public void dead() {
        System.out.println("Player " + this.name + " lost all his/her ducks.");
        actionDeck.addAll(cardsToUse);
        cardsToUse.clear();
        this.alive = false;

    }

    public boolean isAlive() {
        return this.alive;
    }

    public String getName() {
        return name;
    }
}
