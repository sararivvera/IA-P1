package algoritmes;

import java.util.List;
import model.Casella;
import model.Mapa;
import heuristiques.Heuristica;

public abstract class AlgoritmeCami {

    public abstract List<Casella> trobarCami(
            Casella inici,
            Casella fi,
            Mapa mapa,
            Heuristica heuristica
    );
}