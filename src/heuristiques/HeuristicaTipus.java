package heuristiques;

import model.Casella;

/**
 * Heurística 2: distància Manhattan ponderada pel cost del tipus de la casella actual.
 *
 * h(n) = manhattan(n, destí) * cost_tipus_actual
 *
 * NO ADMISSIBLE en general:
 *   - Si la cel·la actual té un cost elevat (per exemple 2 = comarcal) però el camí
 *     cap al destí es pot recórrer per caselles més barates (0.5 = autovia), llavors
 *     h = r * cost_actual pot sobreestimar el cost real. Exemple: actual de tipus C
 *     i totes les següents A => h calcula M*2 mentre el cost real serà proper a M*0.5.
 *   - L'única fórmula que garanteix admisibilitat és usar el menor cost possible
 *     (p. ex. 0.5) en la ponderació: h = manhattan * min_cost.
 */
public class HeuristicaTipus extends Heuristica {

    @Override
    public double calcular(Casella actual, Casella objectiu) {
        double r = Math.abs(actual.getX() - objectiu.getX()) +
                   Math.abs(actual.getY() - objectiu.getY());

        return (r * actual.getCost());
    }
}
