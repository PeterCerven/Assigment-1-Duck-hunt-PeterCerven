package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;

import java.util.ArrayList;
import java.util.Collections;

public class Scatter extends ActionCard {
    private final ArrayList<NonActionCard> board;

    public Scatter(ArrayList<NonActionCard> board) {
        this.board = board;
    }

    @Override
    public String getName() {
        return "Scatter";
    }

    @Override
    public boolean playable() {
        return true;
    }


    @Override
    public void action() {
        Collections.shuffle(board);
        System.out.println(getName() + " was played.");
    }
}
