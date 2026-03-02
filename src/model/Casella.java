package model;

public class Casella {

    private final int x;
    private final int y;
    private final TipusCasella tipus;

    public Casella(int x, int y, TipusCasella tipus) {
        this.x = x;
        this.y = y;
        this.tipus = tipus;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public TipusCasella getTipus() { return this.tipus; }
    public double getCost() { return tipus.getCost(); }
    public boolean esTransitable() { return tipus.esTransitable(); }

}