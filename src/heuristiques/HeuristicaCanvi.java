package heuristiques;

import model.Casella;

/**
 * Heurística 3: distància Manhattan * cost mínim (0.5) + penalització de canvi si els tipus difereixen.
 *
 * h(n) = 0.5 * manhattan(n, destí) + (tipus_n != tipus_destí ? 3 : 0)
 *
 * ADMISSIBLE:
 *   - Cada pas costa com a mínim 0.5 (autovia), per tant el cost real >= 0.5 * manhattan.
 *   - Si el tipus de la casella actual és diferent del destí, obligatòriament s'haurà de fer
 *     almenys un canvi de tipus al llarg del camí (en algun pas s'entrarà al tipus del destí),
 *     cosa que comporta +3. Per tant el cost real >= 0.5 * manhattan + 3.
 *   => h(n) <= cost real sempre. L'heurística és admissible.
 */
public class HeuristicaCanvi extends Heuristica {

    @Override
    public double calcular(Casella actual, Casella objectiu) {
        int manhattan = Math.abs(actual.getX() - objectiu.getX()) +
                        Math.abs(actual.getY() - objectiu.getY());

        double h = 0.5 * manhattan;

        if (actual.getTipus() != objectiu.getTipus()) {
            h += 3;
        }

        return h;
    }
}
