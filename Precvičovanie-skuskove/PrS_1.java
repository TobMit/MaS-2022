import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class PrS_1 {
    private static final int pocetReplikaci = 100;
    private static double  prPokazeniaCon = 0.15;
    public static void main(String[] args) {
        UniformContinuousRNG prPokazenia = new UniformContinuousRNG();
        TriangularRNG vekDomu = new TriangularRNG(10.0, 20.0,30.0);
        TriangularRNG vyskaNakladov = new TriangularRNG(5000.0, 80000.0,120000.0);
        double prispevok = 0;
        boolean koniec = false;
        while (!koniec) {
            prispevok++;
            double uspech = 0;
            for (int i = 0; i < pocetReplikaci; i++) {
                double naklady = 0;
                for (int j = 0; j < 30; j++) {
                    if (prPokazenia.sample() <= prPokazeniaCon) {
                        naklady += vyskaNakladov.sample();
                    }
                }
                if (naklady <= prispevok * 1600) {
                    uspech++;
                }
            }
            if (uspech/pocetReplikaci >= 0.98) {
                koniec= true;

            }
        }

        System.out.println("Pripsevok ma byt: " + prispevok);
    }
}
