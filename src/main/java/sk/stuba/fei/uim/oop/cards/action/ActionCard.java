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

    protected void shootPosition(int position){
        int index;
        if (this.board.get(position).getName().contains("Duck")) {
            index = findOwnerIndex(this.board.get(position).getOwner());
            this.board.remove(position);
            this.board.add(boardDeck.get(0));
            this.boardDeck.remove(0);
            System.out.println(players[index].name + "'s Duck was shot on position " + (position + 1));
            this.players[index].loseHealth();

        } else {
            System.out.println(this.board.get(position).getName() + " was shoot on position " + (position + 1));
        }
    }

    protected int findOwnerIndex(String owner) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].name.equals(owner)) {
                return i;
            }
        }
        return -1;
    }
}
