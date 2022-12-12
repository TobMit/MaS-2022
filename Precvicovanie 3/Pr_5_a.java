import OSPRNG.UniformContinuousRNG;

public class Pr_5_a {
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
        for (int i = 0; i < pocetReplikaci; i++) {
            boolean prvaPravda = pravda1.sample() < prPravda;
            boolean druhaPravda = pravda2.sample() < prPravda;
            boolean tretiaPravda = pravda3.sample() < prPravda;

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
        System.out.println("Pravdepodobnost ze majú pravdu 2: " + pocetZeSaZhodliDveAPravda/pocetZeSaZhodliDve * 100 + " pravdepodbnost ze maju pravdu 3: " + pocetZeSaZhodliTriAPravda/pocetZeSaZhodliTri * 100);
    }
}
