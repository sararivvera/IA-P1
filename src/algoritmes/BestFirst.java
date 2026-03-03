package algoritmes;

import java.util.*;

import model.*;
import heuristiques.*;

/**
 * Best-First Search (voraç/greedy).
 * Ordena la cua de prioritat únicament per el valor heurístic.
 * No garanteix solució òptima, però sol explorar menys estats.
 */
public class BestFirst extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        // Cua de prioritat ordenada per h (menor h = més prioritat)
        PriorityQueue<Node> obert = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
        // Conjunt de caselles ja expandides (no es tornen a expandir)
        Set<String> tancat = new HashSet<>();

        int estats = 0;

        double hInici = heuristica.calcular(inici, fi);
        obert.add(new Node(inici, null, 0.0, hInici));

        while (!obert.isEmpty()) {
            Node actual = obert.poll();
            Casella casActual = actual.getCasella();
            String clau = casActual.getX() + "," + casActual.getY();

            // Saltem si ja l'hem expandit
            if (tancat.contains(clau)) continue;
            tancat.add(clau);
            estats++;

            // Comprovem si hem arribat al destí
            if (casActual.getX() == fi.getX() && casActual.getY() == fi.getY()) {
                List<Casella> cami = actual.reconstruirCami();
                imprimirResultat(cami, actual.getG(), estats);
                return cami;
            }

            // Generem successors
            for (Casella vei : getVeins(casActual, mapa)) {
                String clauVei = vei.getX() + "," + vei.getY();
                if (!tancat.contains(clauVei)) {
                    double gVei = actual.getG() + calcularCost(casActual, vei);
                    double hVei = heuristica.calcular(vei, fi);
                    obert.add(new Node(vei, actual, gVei, hVei));
                }
            }
        }

        System.out.println("  -> No s'ha trobat cap camí. Estats tractats: " + estats);
        return null;
    }
}
