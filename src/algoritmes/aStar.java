package algoritmes;

import java.util.List;
import model.Casella;
import model.Mapa;
import heuristiques.Heuristica;

public class AStar extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        double hInicial = heuristica.calcular(inici, fi);

        // Implementación A*
        return null;
    }
}