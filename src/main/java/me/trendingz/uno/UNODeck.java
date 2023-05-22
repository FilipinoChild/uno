package me.trendingz.uno;

import java.util.*;

public class UNODeck {
    private ArrayList<UNOCard> cards;

    public UNODeck() {
        cards = new ArrayList<UNOCard>();
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Draw Two", "Skip", "Reverse"};

        for (String color : colors) {
            for (int i = 0; i < values.length; i++) {
                cards.add(new UNOCard(color, values[i]));

                if (!values[i].equals("0")) {
                    cards.add(new UNOCard(color, values[i]));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new UNOCard("Special", "Color Change"));
            cards.add(new UNOCard("Special", "Plus Four"));
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

