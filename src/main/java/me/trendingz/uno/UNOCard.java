package me.trendingz.uno;

//adadw
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

    @Override
    public String toString() {
        return color + " " + value;
    }
}
