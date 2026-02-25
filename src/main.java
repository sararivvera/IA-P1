import algoritmes.*;
import heuristiques.*;
import model.*;

public class Main {

    public static void main(String[] args) {

        Mapa mapa1 = new Mapa(10, 10);
        Mapa mapa2 = new Mapa(10, 10);

        Casella inici = mapa1.getCasella(0, 0);
        Casella fi    = mapa1.getCasella(9, 9);

        AlgoritmeCami bestFirst = new BestFirst();
        AlgoritmeCami aStar     = new AStar();

        Heuristica h1 = new HeuristicaManhattan();
        Heuristica h2 = new HeuristicaEuclidiana();
        Heuristica h3 = new HeuristicaPersonalitzada();

        // BestFirst
        bestFirst.trobarCami(inici, fi, mapa1, h1);
        bestFirst.trobarCami(inici, fi, mapa2, h1);
        bestFirst.trobarCami(inici, fi, mapa1, h2);
        bestFirst.trobarCami(inici, fi, mapa2, h2);
        bestFirst.trobarCami(inici, fi, mapa1, h3);
        bestFirst.trobarCami(inici, fi, mapa2, h3);

        // AStar
        aStar.trobarCami(inici, fi, mapa1, h1);
        aStar.trobarCami(inici, fi, mapa2, h1);
        aStar.trobarCami(inici, fi, mapa1, h2);
        aStar.trobarCami(inici, fi, mapa2, h2);
        aStar.trobarCami(inici, fi, mapa1, h3);
        aStar.trobarCami(inici, fi, mapa2, h3);
    }
}