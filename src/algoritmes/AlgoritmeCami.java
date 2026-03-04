package algoritmes;

import java.util.ArrayList;
import java.util.List;

import model.*;
import heuristiques.*;

public abstract class AlgoritmeCami {

    public abstract List<Casella> trobarCami(
            Casella inici,
            Casella fi,
            Mapa mapa,
            Heuristica heuristica
    );

    /**
     * Cost de moure's d'origen a desti:
     *    cost base = cost del tipus de casella destí
     *    +3 si es canvia de tipus de carretera
     */
    protected double calcularCost(Casella origen, Casella desti) {
        double cost = desti.getCost();
        if (origen.getTipus() != desti.getTipus()) {
            cost += 3;
        }
        return cost;
    }

    /**
     * Retorna les caselles veïnes transitables (dalt, baix, esquerra, dreta).
     */
    protected List<Casella> getVeins(Casella casella, Mapa mapa) {
        List<Casella> veins = new ArrayList<>();
        int x = casella.getX();
        int y = casella.getY();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < mapa.getFiles() && ny >= 0 && ny < mapa.getColumnes()) {
                Casella vei = mapa.getCasella(nx, ny);
                if (vei.esTransitable()) {
                    veins.add(vei);
                }
            }
        }
        return veins;
    }

    /** Clau única per identificar una casella al mapa. */
    protected String clau(Casella c) {
        return c.getX() + "," + c.getY();
    }

    /**
     * Imprimeix el camí trobat, el cost total i el nombre d'estats tractats.
     */
    protected void imprimirResultat(List<Casella> cami, double cost, int estats) {
        System.out.print("  Camí: ");
        for (Casella c : cami) {
            System.out.print("(" + c.getX() + "," + c.getY() + ")");
            if (cami.indexOf(c) < cami.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
        System.out.printf("  Cost total: %.2f | Estats tractats: %d%n", cost, estats);
    }
}
