package me.trendingz.uno;

import java.util.*;

public class UNODeck {
    private ArrayList<UNOCard> cards;

    public UNODeck() {
        cards = new ArrayList<UNOCard>();
        String[] suits = {"Red", "Blue", "Green", "Yellow"};
        String[] types = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Draw Two", "Skip", "Reverse"};

        for (String suit : suits) {
            for (int i = 0; i < types.length; i++) {
                cards.add(new UNOCard(suit, types[i]));

                if (!types[i].equals("0")) {
                    cards.add(new UNOCard(suit, types[i]));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UNOCard drawCard() {
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }
}

