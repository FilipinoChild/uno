package me.trendingz.uno;

import java.util.ArrayList;

public class UNO {

    private static UNO instance;
    private ArrayList<UNOPlayer> players;
    private UNODeck deck;
    private UNODiscardPile discardPile;
    private UNOPlayer currentPlayer;
    
    public UNO() {
        this.instance = this;
        this.players = new ArrayList<>();
        this.deck = new UNODeck();
        this.discardPile = new UNODiscardPile();
    }

    public static UNO getInstance() {
        return instance;
    }

    public ArrayList<UNOPlayer> getPlayers() {
        return this.players;
    }

    public UNODeck getDeck() {
        return this.deck;
    }

    public UNODiscardPile getDiscardPile() {
        return this.discardPile;
    }

    public void startGame() {
        deck.shuffle();
        dealCards();
        discardPile.addCard(deck.drawCard());
        currentPlayer = players.get(0);
        while (!gameOver()) {
            System.out.println(currentPlayer.getName() + "'s turn");
            currentPlayer.playTurn(discardPile);
            nextPlayer();
        }
        System.out.println("Game over!");
    }

    public void addPlayer(UNOPlayer player) {
        players.add(player);
    }

    private void dealCards() {
        for (UNOPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck.drawCard());
            }
        }
    }

    public void nextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        if (currentIndex == players.size() - 1) {
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(currentIndex + 1);
        }
    }

    public UNOPlayer getPlayerAfter() {
        UNOPlayer playerAfter;

        int currentIndex = players.indexOf(currentPlayer);
        if (currentIndex == players.size() - 1) {
            playerAfter = players.get(0);
        } else {
            playerAfter = players.get(currentIndex + 1);
        }
        
        return playerAfter;
    }

    private boolean gameOver() {
        for (UNOPlayer player : players) {
            if (player.hasEmptyHand()) {
                System.out.println(player.getName() + " wins!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UNO game = new UNO();
        game.addPlayer(new UNOPlayer("Player 1"));
        game.addPlayer(new UNOPlayer("Player 2"));
        game.addPlayer(new UNOPlayer("Player 3"));
        game.addPlayer(new UNOPlayer("Player 4"));
        game.startGame();
    }
}