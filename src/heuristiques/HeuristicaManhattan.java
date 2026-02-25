package heuristiques;

import model.Casella;

public class HeuristicaManhattan extends Heuristica {

    @Override
    public double calcular(Casella actual, Casella objectiu) {
        return Math.abs(actual.getX() - objectiu.getX()) +
               Math.abs(actual.getY() - objectiu.getY());
    }
    
}