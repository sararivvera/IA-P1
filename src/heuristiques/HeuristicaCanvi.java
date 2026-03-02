package heuristiques;

import model.Casella;

public class HeuristicaCanvi extends Heuristica {
    
    @Override
    public float calcular(Casella actual, Casella objectiu) {

        float h = Math.abs(actual.getX() - objectiu.getX()) +
                  Math.abs(actual.getY() - objectiu.getY());

        if actual.getTipus == objectiu.getTipus {
            return h;
        } else {
            return h + 3;
        }

    }
    
}
