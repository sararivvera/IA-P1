package algoritmes;

import model.Casella;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa un node de cerca: una casella + el camí recorregut fins a ella.
 */
public class Node {

    private final Casella casella;
    private final Node pare;
    private final double g;  // cost acumulat real des de l'inici
    private final double h;  // valor heurístic estimat fins al destí

    public Node(Casella casella, Node pare, double g, double h) {
        this.casella = casella;
        this.pare = pare;
        this.g = g;
        this.h = h;
    }

    public Casella getCasella() { return casella; }
    public Node getPare() { return pare; }
    public double getG() { return g; }
    public double getH() { return h; }
    public double getF() { return g + h; }

    /**
     * Reconstrueix el camí des de l'inici fins a aquest node seguint els pares.
     */
    public List<Casella> reconstruirCami() {
        List<Casella> cami = new ArrayList<>();
        Node actual = this;
        while (actual != null) {
            cami.add(actual.casella);
            actual = actual.pare;
        }
        Collections.reverse(cami);
        return cami;
    }
}
