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

    public void checkMatchingCards() {
        UNO uno = UNO.getInstance();
        UNODiscardPile unoDiscardPile = uno.getDiscardPile();

        hand.forEach(card ->{

        });
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
            boolean isSpecial = card.getColor().equals("Special");
            if (card.matches(discardPile.getLastCard()) || isSpecial) 
            {
                doCardTyping(card);
                checkForSpecials(card, discardPile);
                hand.remove(index);
                if (!isSpecial) discardPile.addCard(card);
                validPlay = true;
            } 
            else 
            {
                System.out.println("Invalid card. Try again.");
            }
        }
    }

    private void doCardTyping(UNOCard card) {
        UNO uno = UNO.getInstance();
        UNODeck unoDeck = uno.getDeck();
        ArrayList<UNOPlayer> players = uno.getPlayers();
        UNOPlayer playerAfter = uno.getPlayerAfter();

        boolean isReverse = card.getValue().equals("Reverse");
        boolean isSkip = card.getValue().equals("Skip");
        boolean isDrawTwo = card.getValue().equals("Draw Two");

        if (isReverse) Collections.reverse(players);
        else if (isSkip) uno.nextPlayer();
        else if (isDrawTwo) {
            for (int i = 0; i < 2; i++) {
                playerAfter.drawCard(unoDeck.drawCard());
            }
        }
    }

    private void checkForSpecials(UNOCard card, UNODiscardPile unoDiscardPile) {
        UNO uno = UNO.getInstance();
        UNODeck unoDeck = uno.getDeck();
        UNOPlayer playerAfter = uno.getPlayerAfter();

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        boolean isSpecial = card.getColor().equals("Special");
        boolean isColorChange = card.getValue().equals("Color Change");
        boolean isPlusFour = card.getValue().equals("Plus Four");
        Scanner scanner = new Scanner(System.in);
        boolean validPlay = false;
        
        if (isSpecial && (isColorChange || isPlusFour)) {
            System.out.println("Pick Color: " + colors);
            System.out.print("Enter color index to play (0-" + (colors.size() - 1) + "): ");
            int index = scanner.nextInt();
            String color = colors.get(index);
            while (!validPlay) {
                if (colors.contains(color)) 
                {
                    UNOCard specialCard = new UNOCard(color, card.getValue());
                    if (isPlusFour) {
                        for (int i = 0; i < 4; i++) {
                            playerAfter.drawCard(unoDeck.drawCard());
                        }
                    }
                    unoDiscardPile.addCard(specialCard);
                    validPlay = true;
                } 
                else 
                {
                    System.out.println("Invalid color. Try again.");
                }
            }
        }
    }
}

