package me.trendingz.uno;

import java.util.ArrayList;

public class UNO {

    private ArrayList<Player> players;
    private Deck deck;
    private DiscardPile discardPile;
    private Player currentPlayer;

    public UnoGame() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.discardPile = new DiscardPile();
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

    public void addPlayer(Player player) {
        players.add(player);
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck.drawCard());
            }
        }
    }

    private void nextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        if (currentIndex == players.size() - 1) {
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(currentIndex + 1);
        }
    }

    private boolean gameOver() {
        for (Player player : players) {
            if (player.hasEmptyHand()) {
                System.out.println(player.getName() + " wins!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UnoGame game = new UnoGame();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.addPlayer(new Player("Player 4"));
        game.startGame();
    }
}