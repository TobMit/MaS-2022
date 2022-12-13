import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Pr_10 {
    public static void main(String[] args) {
        // burzový maklér
        //int pocetReplikacii = 10;
        int pocetReplikacii = 1000000;
        int pocetTyzdnov = 52;
        int pocetDni = pocetTyzdnov * 7;
        double fond = 10000;
        double primerFontA = 0;
        double primerFontB = 0;
        TriangularRNG zmenaAFondu = new TriangularRNG(-5.0, 1.4, 3.5);
        UniformContinuousRNG zmenaBfondu = new UniformContinuousRNG(-2.5, 4.5);
        for (int i = 0; i < pocetReplikacii; i++) {
            double fondA = fond;
            double fondB = fond;
            for (int j = 0; j < pocetDni; j++) {
                double percentaA = zmenaAFondu.sample();
                if (percentaA < 0) {
                    percentaA = Math.abs(percentaA);
                    percentaA = (100 - percentaA)/100;
                } else {
                    percentaA = (100 + percentaA)/100;
                }
                fondA *= percentaA;

                // ide riešiť týždne
                if (j < pocetTyzdnov) {
                    double percentaB = zmenaBfondu.sample();
                    if (percentaB < 0) {
                        percentaB = Math.abs(percentaB);
                        percentaB = (100 - percentaB)/100;
                    } else {
                        percentaB = (100 + percentaB)/100;
                    }
                    fondB *= percentaB;
                }

            }
            //System.out.println(fondA + " " + fondB);
            primerFontA += fondA;
            primerFontB += fondB;
        }
        System.out.println("Fond A: " + primerFontA / pocetReplikacii);
        System.out.println("Fond B: " + primerFontB / pocetReplikacii);

    }
}
