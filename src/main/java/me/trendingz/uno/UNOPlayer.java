package me.trendingz.uno;

import java.util.ArrayList;
import java.util.Collections;
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
            if (card.matches(discardPile.getLastCard())) 
            {
                doCardTyping(card);
                hand.remove(index);
                discardPile.addCard(card);
                validPlay = true;
            } 
            else 
            {
                System.out.println("Invalid card. Try again.");
            }
        }
    }

    public void doCardTyping(UNOCard card) {
        UNO uno = UNO.getInstance();
        UNODeck unoDeck = uno.getDeck();
        ArrayList<UNOPlayer> players = uno.getPlayers();

        if (card.getValue().equals("Reverse")) Collections.reverse(players);
        else if (card.getValue().equals("Skip")) uno.nextPlayer();
        else if (card.getValue().equals("Draw Two")) {
            for (int i = 0; i < 2; i++) {
                this.drawCard(unoDeck.drawCard());
            }
        }
        else if (card.getValue().equals("Draw Four")) {
            for (int i = 0; i < 4; i++) {
                this.drawCard(unoDeck.drawCard());
            }
        }
    }
}

