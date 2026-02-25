package model;

public class Casella {

    public enum TipusCasella {
        BLANC,
        AUTOVIA,
        NACIONAL,
        COMARCAL
    }
    
    // Atributs d'estat
    private int x;
    private int y;
    private TipusCasella tipus;

    // Constructor
    public Casella(int x, int y, TipusCasella tipus) {
        this.x = x;
        this.y = y;
        this.tipus = tipus;
    }

    // Getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public TipusCasella getTipus() {
        return this.tipus;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTipus(TipusCasella tipus) {
        this.tipus = tipus;
    }
}