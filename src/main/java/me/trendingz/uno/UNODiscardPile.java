package me.trendingz.uno;

import java.util.ArrayList;

public class UNODiscardPile {
    private ArrayList<UNOCard> pile;

    public UNODiscardPile() {
        pile = new ArrayList<UNOCard>();
    }

    public void addCard(UNOCard card) {
        pile.add(card);
    }

    public UNOCard getLastCard() {
        if (pile.isEmpty()) {
            return null;
        }
        return pile.get(pile.size() - 1);
    }

    /*public UNOCard getTopCard() {
        if (pile.isEmpty()) {
            return null;
        }
        return pile.get(0);
    }*/

    public void printPile() {
        System.out.println("Discard pile: ");
        for (UNOCard card : pile) {
            System.out.println(card.toString());
        }
    }

    public void clearPile() {
        pile.clear();
    }
}

