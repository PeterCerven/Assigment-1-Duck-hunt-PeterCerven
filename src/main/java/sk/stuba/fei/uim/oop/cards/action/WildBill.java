package sk.stuba.fei.uim.oop.cards.action;

import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class WildBill extends ActionCard {
    boolean[] aimers;
    private final ArrayList<NonActionCard> board;
    private final ArrayList<NonActionCard> boardDeck;
    private final Player[] players;

    public WildBill(boolean[] aimers, ArrayList<NonActionCard> board, ArrayList<NonActionCard> boardDeck, Player[] players) {
        this.aimers = aimers;
        this.board = board;
        this.boardDeck = boardDeck;
        this.players = players;
    }

    @Override
    public String getName() {
        return "WildBill";
    }

    @Override
    public boolean playable() {
        return true;
    }

    public int findOwnerIndex(String owner) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].name.equals(owner)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void action() {
        int index;
        int position = KeyboardInput.readInt("Choose postition between 1 and 6") - 1;
        if (this.board.get(position).getName().contains("Duck")) {
            index = findOwnerIndex(this.board.get(position).getOwner());
            board.remove(position);
            board.add(boardDeck.get(0));
            boardDeck.remove(0);
            System.out.println(players[index].name + "'s Duck was shot on position " + (position + 1) + ".");
            players[index].loseHealth();

        } else {
            System.out.println(this.board.get(position).getName() + " was shoot on position " + (position + 1) + ".");
        }
        aimers[position] = false;

    }
}
