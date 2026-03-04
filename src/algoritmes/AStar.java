package algoritmes;

import java.util.*;

import model.*;
import heuristiques.*;

/**
 * A* 
 * Ordena pends per f(N) = g(N) + h(N): cost real + heurística.
 * Garanteix solució òptima si la heurística és admissible.
 */
public class AStar extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        // pends := (Ei, 0, h(Ei)). ordenat per f(N) = g(N) + h(N)
        PriorityQueue<Node> pends = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Set<String> tracts = new HashSet<>();           // tracts := 0
        Map<String, Double> millorG = new HashMap<>();  // cost(obtenirCamí(X, pends))
        boolean trobat = false;
        int estats = 0;

        pends.add(new Node(inici, null, 0.0, heuristica.calcular(inici, fi)));
        millorG.put(clau(inici), 0.0);

        // mentre no(trobat) i (pends != 0) fer
        while (!trobat && !pends.isEmpty()) {

            // [N, camí, valor] := Primer(pends); Eliminar_primer(pends)
            Node nodeN = pends.poll();
            Casella N = nodeN.getCasella();
            String clauN = clau(N);

            // Saltem nodes obsolets (ja processats via un camí millor, ja estan a tracts)
            if (tracts.contains(clauN)) continue;
            estats++;

            // si N = Ef
            if (N.getX() == fi.getX() && N.getY() == fi.getY()) {
                trobat = true;
                List<Casella> cami = nodeN.reconstruirCami();
                imprimirResultat(cami, nodeN.getG(), estats);
                return cami;

            } else {
                // per tot successor X de N fer
                for (Casella X : getVeins(N, mapa)) {
                    String clauX = clau(X);
                    double gX = nodeN.getG() + calcularCost(N, X);

                    // si X no pertany a tracts
                    if (!tracts.contains(clauX)) {
                        // si X no pertany a pends -> Afegir_orden
                        // sino si cost(camí+op) < cost(obtenirCamí(X,pends)) -> Sobreescriure_ordre
                        // (millorG implementa obtenirCamí de forma eficient)
                        if (gX < millorG.getOrDefault(clauX, Double.MAX_VALUE)) {
                            millorG.put(clauX, gX);
                            pends.add(new Node(X, nodeN, gX, heuristica.calcular(X, fi)));
                        }
                    }
                }
                // tracts := tracts + {N}
                tracts.add(clauN);
            }
        }

        System.out.println("  -> No s'ha trobat cap cami. Estats tractats: " + estats);
        return null;
    }
}
