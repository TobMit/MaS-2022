import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;
import OSPRNG.UniformDiscreteRNG;

public class PrS_3 {
    private static final int pocetPlienokVBaleni = 26;
    public static void main(String[] args) {
        TriangularRNG porodnaHmotnost = new TriangularRNG(2900.0, 3600.0,4500.0);
        // poison
        UniformDiscreteRNG prirastok = new UniformDiscreteRNG(140, 280);
        TriangularRNG spotrebaPlienok = new TriangularRNG(4.0, 8.0, 12.0);
        double pocetBaleni = 0;
        boolean koniec = false;
        while (!koniec) {
            pocetBaleni++;
            double uspech = 0;
            for (int i = 0; i < 1000000; i++) { // replikacie
                double vahaDietata = porodnaHmotnost.sample();
                double pocetMinutychPlienok = 0;
                while (vahaDietata <= 5000) {
                    vahaDietata += prirastok.sample();
                    pocetMinutychPlienok += spotrebaPlienok.sample();
                }
                if (pocetMinutychPlienok <= pocetBaleni * pocetPlienokVBaleni) {
                    uspech++;
                }
            }
            if (uspech/1000000 >= 0.95) {
                koniec = true;
            }
        }


        System.out.println("Pocet baleni je: " + pocetBaleni);
    }
}
