import algoritmes.*;
import heuristiques.*;
import model.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Mapes a provar: el de l'enunciat i el dissenyat per nosaltres
        String[] fitxers = {
            "mapa1.txt",
            "mapa2.txt"
        };

        AlgoritmeCami[] algoritmes = {
            new BestFirst(),
            new AStar()
        };

        Heuristica[] heuristiques = {
            new HeuristicaManhattan(),  // H1: distància Manhattan pura (NO admissible)
            new HeuristicaCanvi(),      // H2: 0.5*manhattan + penalització canvi (ADMISSIBLE)
            new HeuristicaTipus()       // H3: manhattan * cost_tipus_destí (NO admissible)
        };

        // Detecta el directori base (funciona tant des de la rel del projecte com des de src/)
        String base = new java.io.File("src/model/mapes/mapa1.txt").exists()
                      ? "src/model/mapes/"
                      : "model/mapes/";

        for (String nomFitxer : fitxers) {

            Mapa mapa = new Mapa(base + nomFitxer);
            Casella inici = mapa.getCasella(0, 0);
            Casella fi    = mapa.getCasella(9, 9);

            System.out.println("\n" + "=".repeat(70));
            System.out.println("MAPA: " + nomFitxer
                + "  |  Inici: (" + inici.getX() + "," + inici.getY() + ") [" + inici.getTipus() + "]"
                + "  |  Destí: (" + fi.getX()    + "," + fi.getY()    + ") [" + fi.getTipus()    + "]");
            System.out.println("=".repeat(70));

            for (AlgoritmeCami algoritme : algoritmes) {
                for (Heuristica heuristica : heuristiques) {

                    System.out.println("\n[" + algoritme.getClass().getSimpleName()
                        + " + " + heuristica.getClass().getSimpleName() + "]");

                    algoritme.trobarCami(inici, fi, mapa, heuristica);
                }
            }
        }
    }
}
