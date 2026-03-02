package heuristiques;

import model.Casella;

public class HeuristicaTipus extends Heuristica {
 
    @Override
    public float calcular(Casella actual, Casella objectiu) {
        return [Math.abs(actual.getX() - objectiu.getX()) +
               Math.abs(actual.getY() - objectiu.getY())] *
               objectiu.getTipus();
    }

}
