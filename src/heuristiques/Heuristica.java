package heuristiques;

import model.Casella;

public abstract class Heuristica {
    public abstract double calcular(Casella actual, Casella objectiu);
}