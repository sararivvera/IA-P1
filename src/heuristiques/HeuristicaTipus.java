package heuristiques;

import model.Casella;

/**
 * Heurística 3: distància Manhattan ponderada pel cost del tipus de la casella destí.
 *
 * h(n) = manhattan(n, destí) * cost_tipus_destí
 *
 * NO ADMISSIBLE en general:
 *   - Si el destí és Nacional (cost=1): h = manhattan, igual que H1 -> sobreestima
 *     quan hi ha autovies al camí (cost real pot ser 0.5 * manhattan).
 *   - Si el destí és Comarcal (cost=2): h = 2 * manhattan -> sobreestima.
 *   - Només seria admissible si el destí és Autovia (cost=0.5), ja que en aquest
 *     cas h = 0.5 * manhattan <= cost real.
 */
public class HeuristicaTipus extends Heuristica {

    @Override
    public double calcular(Casella actual, Casella objectiu) {
        double r = Math.abs(actual.getX() - objectiu.getX()) +
                   Math.abs(actual.getY() - objectiu.getY());

        return (r * objectiu.getCost());
    }
}
