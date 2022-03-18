package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;

import java.util.ArrayList;

public abstract class ActionCard {
    public abstract void action(ArrayList<NonActionCard> boardDeck, boolean[] aimers);

    public abstract String getName();

}
