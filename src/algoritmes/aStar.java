package algoritmes;

import java.util.List;
import model.*;
import heuristiques.Heuristica;

public class AStar extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        double hInicial = heuristica.calcular(inici, fi);

        // TODO: Implementación A*

        return null;
    }
}