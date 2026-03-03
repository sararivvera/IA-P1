package heuristiques;

import model.Casella;

/**
 * Heurística 1: distància Manhattan pura (nombre de passos fins al destí).
 *
 * h(n) = |x_actual - x_destí| + |y_actual - y_destí|
 *
 * NO ADMISSIBLE:
 *   - Ignora els costos de les carreteres.
 *   - Si el camí passa per autovies (cost 0.5 per pas), el cost real pot ser
 *     0.5 * manhattan, però la heurística retorna manhattan -> sobreestima.
 *   - Exemple: actual=(0,0), destí=(1,0), ambdues autovies.
 *     h = 1, cost real = 0.5 -> h > cost real.
 */
public class HeuristicaManhattan extends Heuristica {

    @Override
    public double calcular(Casella actual, Casella objectiu) {
        return Math.abs(actual.getX() - objectiu.getX()) +
               Math.abs(actual.getY() - objectiu.getY());
    }
}