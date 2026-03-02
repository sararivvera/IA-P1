import algoritmes.*;
import heuristiques.*;
import model.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] fitxers = {
            "mapa1.txt",
            "mapa2.txt",
            "mapaBlanc.txt"
        };

        AlgoritmeCami[] algoritmes = {
            new BestFirst(),
            new AStar()
        };

        Heuristica[] heuristiques = {
            new HeuristicaManhattan(),
            new HeuristicaCanvi(),
            new HeuristicaTipus()
        };

        for (String path : fitxers) {

            Mapa mapa = new Mapa("model/mapes/" + path);

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