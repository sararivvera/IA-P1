package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mapa {

    private Casella[][] graella;
    private int files;
    private int columnes;

    public Mapa(String pathFitxer) throws IOException {

        List<String[]> linies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathFitxer))) {
            String linia;

            while ((linia = br.readLine()) != null) {
                linia = linia.trim();

                if (!linia.isEmpty()) {
                    linies.add(linia.split("\\s+"));
                }
            }
        }

        // Dimensions
        this.files = linies.size();
        this.columnes = linies.get(0).length;

        // Inicialitzar graella
        graella = new Casella[files][columnes];

        // Construcció de caselles
        for (int i = 0; i < files; i++) {

            if (linies.get(i).length != columnes) {
                throw new IllegalArgumentException("Mapa no rectangular al fitxer.");
            }

            for (int j = 0; j < columnes; j++) {

                String valor = linies.get(i)[j];

                TipusCasella tipus;

                try {
                    tipus = TipusCasella.valueOf(valor);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(
                        "Tipus de casella desconegut: " + valor
                    );
                }

                graella[i][j] = new Casella(i, j, tipus);
            }
        }
    }

    public Casella getCasella(int x, int y) {
        return graella[x][y];
    }

    public int getFiles() {
        return files;
    }

    public int getColumnes() {
        return columnes;
    }
}