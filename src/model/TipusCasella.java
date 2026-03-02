package model;

public enum TipusCasella {
    
    B(-1),
    A(0.5),
    N(1),
    C(2);

    private final double cost;

    TipusCasella(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    public boolean esTransitable() {
        return this != B;
    }

}