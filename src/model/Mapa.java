package model;

public class Mapa {

    private Casella[][] graella;
    private int files;
    private int columnes;

    public Mapa(int files, int columnes) {
        this.files = files;
        this.columnes = columnes;
        graella = new Casella[files][columnes];

        inicialitzar();
    }

    private void inicialitzar() {
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                graella[i][j] = new Casella(i, j, TipusCasella.NORMAL);
            }
        }
    }

    public Casella getCasella(int x, int y) {
        return graella[x][y];
    }
}