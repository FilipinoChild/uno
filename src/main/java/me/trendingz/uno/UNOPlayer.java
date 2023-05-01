package me.trendingz.uno;

import java.util.ArrayList;
import java.util.Scanner;

public class UNOPlayer {

    private String name;
    private ArrayList<UNOCard> hand;

    public UNOPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void drawCard(UNOCard card) {
        hand.add(card);
    }

    public boolean hasEmptyHand() {
        return hand.isEmpty();
    }

    public void playTurn(UNODiscardPile discardPile) {
        System.out.println("Current card: " + discardPile.getLastCard());
        System.out.println("Your hand: " + hand);
        Scanner scanner = new Scanner(System.in);
        boolean validPlay = false;
        while (!validPlay) {
            System.out.print("Enter card index to play (0-" + (hand.size() - 1) + "): ");
            int index = scanner.nextInt();
            UNOCard card = hand.get(index);
            if (card.matches(discardPile.getLastCard())) {
                hand.remove(index);
                discardPile.addCard(card);
                validPlay = true;
            } else {
                System.out.println("Invalid card. Try again.");
            }
        }
    }
}

