import OSPRNG.TriangularRNG;

import java.util.Set;
import java.util.*;

public class Pr_6_a {
    private static final int pocetReplickaci = 1000000;
    public static void main(String[] args) {
        TriangularRNG fast = new TriangularRNG(40.0, 50.0, 75.0);
        TriangularRNG furios = new TriangularRNG(35.0, 52.0, 80.0);
        double umiestnilSa = 0;
        for (int i = 0; i < pocetReplickaci; i++) {
            TreeMap<Double, Integer> mapaMiest = new TreeMap<>();
            for (int j = 0; j < 5; j++) {
                mapaMiest.put(fast.sample(), 1);
                mapaMiest.put(furios.sample(), 2);
            }
            Set<Map.Entry<Double, Integer> > entrySet = mapaMiest.entrySet();

            // Convert entrySet to Array using toArray method
            Map.Entry<Double, Integer>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);

            if (entryArray[0].getValue() == 1 && entryArray[2].getValue() == 1) {
                umiestnilSa++;
            }

        }
        System.out.println("Pravdepodobnost ze bol na prvych dvoch miestach: " + umiestnilSa/pocetReplickaci*100);
    }
}
