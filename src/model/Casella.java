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

    public float getCost() {
        return switch (this.tipus) {
            case B -> -1.0;       // Cost no vàlid (casella no transitable).
            case A -> 0.5;
            case N -> 1.0;
            case C -> 2.0;
            default -> -1.0;        // Cost no vàlid (casella no transitable).
        }
    }

    public boolean esTransitable() {
        return this.tipus != B;
    }


}