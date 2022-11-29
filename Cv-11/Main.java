import OSPRNG.*;
public class Main {
    public static void main(String[] args) {
        // 1. generovať x a y čislo od 0-1 uniform()
        // 2. porovnáme či to padlo alebo nepadlo
        //        xmin < x < xmax && ymin < y < ymax
        // 3. cyklus 1..n m++
        // 4. vypýsať odchad S' = m/n

        /*
        TriangularRNG genNahCislo = new TriangularRNG(15.0, 25.0, 35.0);
        double nahodneCislo = genNahCislo.sample();
        System.out.println("Nahodne čislo: " + nahodneCislo); */
        double xmin = 0.3, xmax = 0.8, ymin = 0.5, ymax = 0.7;
        int n = 10000, m = 0;

        UniformContinuousRNG unifromNahoda = new UniformContinuousRNG();
        for (int i = 0; i < n; i++) {
            double x = unifromNahoda.sample();
            double y = unifromNahoda.sample();
            if (xmin <= x && x <= xmax &&
                ymin <= y && y <= ymax) {
                m++;
            }
        }

        System.out.printf("S = %d / %d = %f", m, n,(double) m/n);





    }
}
