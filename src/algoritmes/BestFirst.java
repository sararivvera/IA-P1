package algoritmes;

import java.util.*;

import model.*;
import heuristiques.*;

/**
 * Best-First
 * Ordena pends únicament per h(N): el valor heurístic.
 * No garanteix solució òptima, però sol explorar menys estats.
 */
public class BestFirst extends AlgoritmeCami {

    @Override
    public List<Casella> trobarCami(Casella inici, Casella fi, Mapa mapa, Heuristica heuristica) {

        // pends := ([Ei, θ, h(Ei)]). Ordenat per h(N)
        PriorityQueue<Node> pends = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
        Set<String> tracts  = new HashSet<>();  // tracts := θ
        Set<String> enPends = new HashSet<>();  // per comprovar si X pertany a pends
        boolean trobat = false;
        int estats = 0;

        pends.add(new Node(inici, null, 0.0, heuristica.calcular(inici, fi)));
        enPends.add(clau(inici));

        // mentre no(trobat) i (pends != 0) fer
        while (!trobat && !pends.isEmpty()) {

            // [N, camí, valor] := Primer(pends); Eliminar_primer(pends)
            Node nodeN = pends.poll();
            Casella N = nodeN.getCasella();
            enPends.remove(clau(N));
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
                    // si X no pertany a tracts ni a pends -> Afegir_ordre(pends, [X, camí+op, h(X)])
                    if (!tracts.contains(clau(X)) && !enPends.contains(clau(X))) {
                        double gX = nodeN.getG() + calcularCost(N, X);
                        double hX = heuristica.calcular(X, fi);
                        pends.add(new Node(X, nodeN, gX, hX));
                        enPends.add(clau(X));
                    }
                }
                // tracts := tracts + {N}
                tracts.add(clau(N));
            }
        }

        System.out.println("  -> No s'ha trobat cap cami. Estats tractats: " + estats);
        return null;
    }
}
