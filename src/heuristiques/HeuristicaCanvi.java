package heuristiques;

import model.Casella;

public class HeuristicaCanvi extends Heuristica {
    
    @Override
    public double calcular(Casella actual, Casella objectiu) {

        double h = Math.abs(actual.getX() - objectiu.getX()) +
                  Math.abs(actual.getY() - objectiu.getY());

        if actual.getTipus == objectiu.getTipus {
            return h;
        } else {
            return h + 3;
        }

    }
    
}
