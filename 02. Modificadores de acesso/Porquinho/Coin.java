package Porquinho;

public class Coin {
    private double value;
    private int volume;
    private String label;

    private Coin(double value, int volume, String label) {
        super();
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    public static Coin C10 = new Coin(0.10, 1, "10 cents");
    public static Coin C25 = new Coin(0.25, 2, "25 cents");
    public static Coin C50 = new Coin(0.50, 3, "50 cents");
    public static Coin C100 = new Coin(1.0, 4, "100 cents");

    // Getters and Setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        // coins=[0.10:1, 0.50:3]
        return String.format("%.2f", value) + ":" + volume;
    }
}