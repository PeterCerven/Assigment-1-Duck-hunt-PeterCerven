package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;

import java.util.ArrayList;

public abstract class ActionCard {
    public abstract void action(boolean[] aimers,
                                ArrayList<NonActionCard> board,
                                ArrayList<NonActionCard> boardDeck,
                                Player player);

    public abstract String getName();

    public abstract boolean playable(boolean[] aimers);

}
