import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Pr_5_b {
    private static final int pocetReplikaci = 10000000;
    private static double  prPravda = 0.8;
    public static void main(String[] args) {
        double pocetZeSaZhodliTriAPravda = 0;
        double pocetZeSaZhodliTri = 0;
        double pocetZeSaZhodliDve = 0;
        double pocetZeSaZhodliDveAPravda = 0;

        UniformContinuousRNG pravda1 = new UniformContinuousRNG();
        UniformContinuousRNG pravda2 = new UniformContinuousRNG();
        UniformContinuousRNG pravda3 = new UniformContinuousRNG();
        TriangularRNG genPrPravda = new TriangularRNG(30.0, 80.0, 100.0 );
        for (int i = 0; i < pocetReplikaci; i++) {
            boolean prvaPravda = pravda1.sample() *100 < genPrPravda.sample();
            boolean druhaPravda = pravda2.sample()*100 < genPrPravda.sample();
            boolean tretiaPravda = pravda3.sample()*100 < genPrPravda.sample();

            if (prvaPravda == druhaPravda  && prvaPravda == tretiaPravda) {
                pocetZeSaZhodliTri++;
                if (prvaPravda) {
                    pocetZeSaZhodliTriAPravda++;
                }
            }

            if (prvaPravda == druhaPravda) {
                pocetZeSaZhodliDve++;
                if (prvaPravda) {
                    pocetZeSaZhodliDveAPravda++;
                }
            }
        }
        System.out.println("Pravdepodobnost ze majú pravdu 2: " + pocetZeSaZhodliDveAPravda/pocetZeSaZhodliDve + " pravdepodbnost ze maju pravdu 3: " + pocetZeSaZhodliTriAPravda/pocetZeSaZhodliTri);
    }
}
