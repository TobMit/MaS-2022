import OSPRNG.UniformContinuousRNG;

import java.util.Random;

public class Pr_4_1 {
    private static final int pocetKrokov = 1000;
    private static final int pocetReplikacii = 1000000;
    public static void main(String[] args) {
        double priemernaVzdialenost = 0;
        // ich knižnica je strašne pomalá
        UniformContinuousRNG random = new UniformContinuousRNG();
        for (int i = 0; i < pocetReplikacii; i++) {
            int vzdialenostOdStredu = 0;
            for (int j = 0; j < pocetKrokov; j++) {
                if (random.sample() < 0.5) {
                    vzdialenostOdStredu++;
                } else {
                    vzdialenostOdStredu--;
                }
                priemernaVzdialenost += vzdialenostOdStredu;
            }

        }
        double ohadKrokov = Math.sqrt((2*pocetKrokov)/(Math.PI));
        System.out.println("Priemerna vzdialenost je: " + priemernaVzdialenost / pocetReplikacii + " teoretická vzdialenost je: " + ohadKrokov);
    }
}
