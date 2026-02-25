package model;

public class Casella {

    private int x;
    private int y;
    private TipusCasella tipus;

    public Casella(int x, int y, TipusCasella tipus) {
        this.x = x;
        this.y = y;
        this.tipus = tipus;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public TipusCasella getTipus() { return tipus; }
}