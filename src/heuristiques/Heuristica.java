package heuristiques;

import model.Casella;

public abstract class Heuristica {

    public abstract float calcular(Casella actual, Casella objectiu);
    
}