package model;

import java.io.IOException;

public class Mapa {

    private Casella[][] graella;
    private int files;
    private int columnes;

    public Mapa(String pathFitxer) throws IOException {
        // TODO: Funcio que llegeix .txt i converteix en mapa interpretable (o graf amb valors de arestes)
    }

    public Casella getCasella(int x, int y) {
        return graella[x][y];
    }
}