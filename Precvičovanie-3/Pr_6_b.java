import OSPRNG.TriangularRNG;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Pr_6_b {
    private static final int pocetReplickaci = 1000000;
    public static void main(String[] args) {
        TriangularRNG fast = new TriangularRNG(40.0, 50.0, 75.0);
        TriangularRNG furios = new TriangularRNG(35.0, 52.0, 80.0);
        double ziskaViacBodov = 0;
        for (int i = 0; i < pocetReplickaci; i++) {
            int fastPocetBodv = 0;
            int furiosPocetBodv = 0;
            for (int j = 0; j < 15; j++) {
                TreeMap<Double, Integer> mapaMiest = new TreeMap<>();
                for (int l = 0; l < 5; l++) {
                    mapaMiest.put(fast.sample(), 1);
                    mapaMiest.put(furios.sample(), 2);
                }
                Set<Map.Entry<Double, Integer> > entrySet = mapaMiest.entrySet();

                // Convert entrySet to Array using toArray method
                Map.Entry<Double, Integer>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
                int pocetBodov = 10;

                for (int k = 0; k < entryArray.length; k++) {
                    if (entryArray[k].getValue() == 1) {
                        fastPocetBodv += pocetBodov--;
                    } else {
                        furiosPocetBodv += pocetBodov--;
                    }
                }


            }
            if (fastPocetBodv > furiosPocetBodv) {
                ziskaViacBodov++;
            }

        }
        System.out.println("Pravdepodobnost ze ziska viac podov: " + ziskaViacBodov/pocetReplickaci*100);
    }
}
