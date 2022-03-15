package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.cards.nonaction.NonActionCard;
import sk.stuba.fei.uim.oop.game.GameBoard;


public class DeckCards extends GameBoard{

    public void fillNonActionDeck(int numCards, NonActionCard card){

        for (int i = 0; i < numCards; i++){
            super.boardDeck.add(card);
        }
    }
    public void fillActionDeck(int numCards, ActionCard card){
        for (int i = 0; i < numCards; i++){
            super.actionDeck.add(card);
        }
    }
}
