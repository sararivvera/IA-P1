package algoritmes;

import java.util.*;

import model.*;
import heuristiques.*;

/**
 * A* Search.
 * Ordena la cua de prioritat per f(n) = g(n) + h(n).
 * Garanteix solució òptima si la heurística és admissible.
 */
public class AStar extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        // Cua de prioritat ordenada per f = g + h (menor f = més prioritat)
        PriorityQueue<Node> obert = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        // Millor g conegut per a cada casella (clau = "x,y")
        Map<String, Double> millorG = new HashMap<>();

        int estats = 0;

        double hInici = heuristica.calcular(inici, fi);
        obert.add(new Node(inici, null, 0.0, hInici));
        millorG.put(inici.getX() + "," + inici.getY(), 0.0);

        while (!obert.isEmpty()) {
            Node actual = obert.poll();
            Casella casActual = actual.getCasella();
            String clau = casActual.getX() + "," + casActual.getY();
            estats++;

            // Saltem nodes obsolets (ja hem trobat un camí millor per a aquesta casella)
            if (actual.getG() > millorG.getOrDefault(clau, Double.MAX_VALUE)) continue;

            // Comprovem si hem arribat al destí
            if (casActual.getX() == fi.getX() && casActual.getY() == fi.getY()) {
                List<Casella> cami = actual.reconstruirCami();
                imprimirResultat(cami, actual.getG(), estats);
                return cami;
            }

            // Generem successors
            for (Casella vei : getVeins(casActual, mapa)) {
                String clauVei = vei.getX() + "," + vei.getY();
                double gVei = actual.getG() + calcularCost(casActual, vei);

                // Només afegim si hem trobat un camí millor o si és la primera vegada
                if (gVei < millorG.getOrDefault(clauVei, Double.MAX_VALUE)) {
                    millorG.put(clauVei, gVei);
                    double hVei = heuristica.calcular(vei, fi);
                    obert.add(new Node(vei, actual, gVei, hVei));
                }
            }
        }

        System.out.println("  -> No s'ha trobat cap camí. Estats tractats: " + estats);
        return null;
    }
}
