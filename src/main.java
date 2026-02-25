import algoritmes.*;
import heuristiques.*;
import model.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] fitxers = {
            "model/mapes/mapa1.txt",
            "model/mapes/mapa2.txt",
        };

        AlgoritmeCami[] algoritmes = {
            new BestFirst(),
            new AStar()
        };

        Heuristica[] heuristiques = {
            new HeuristicaManhattan(),
            new h2(),
            new h3()
        };

        for (String path : fitxers) {

            Mapa mapa = new Mapa(path);

            Casella inici = mapa.getCasella(0, 0);
            Casella fi    = mapa.getCasella(9, 9);

            for (AlgoritmeCami algoritme : algoritmes) {
                for (Heuristica heuristica : heuristiques) {

                    System.out.println(
                        "Mapa: " + path +
                        " | Algoritme: " + algoritme.getClass().getSimpleName() +
                        " | Heurística: " + heuristica.getClass().getSimpleName()
                    );

                    algoritme.trobarCami(inici, fi, mapa, heuristica);
                }
            }
        }
    }
}