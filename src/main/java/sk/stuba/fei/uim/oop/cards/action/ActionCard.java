package sk.stuba.fei.uim.oop.cards.action;


import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import java.util.ArrayList;

public abstract class ActionCard {
    protected boolean[] aimers;
    protected Player[] players;
    protected ArrayList<NonActionCard> board;
    protected ArrayList<NonActionCard> boardDeck;

    public abstract void action();

    public abstract String getName();

    public abstract boolean playable();

}
