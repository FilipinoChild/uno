package me.trendingz.uno;


public class UNOCard {
    private final String color;
    private final String value;

    public UNOCard(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean matches(UNOCard card) {
        return card.getColor().equals(this.color) && card.getValue().equals(this.getValue());
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
