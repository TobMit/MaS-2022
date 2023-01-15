import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import javax.swing.text.Position;

public class PrS_2 {
    private static final int pocetReplikaci = 100;
    private static double  prPokazeniaCon = 0.15;
    public static void main(String[] args) {
        // dalšia triediaca linka 800 0000
        // jedna linka je schopna 6500 7500 8000 za hodinu
        // zasielky privádzané autami x 30
        // zasielky v aute 1000 2500 3500
        // vytriediť za 3h
        // inak zníži o 1 500
        // 
        UniformContinuousRNG prPokazenia = new UniformContinuousRNG();
        TriangularRNG spracovanieListov = new TriangularRNG(6500.0, 7500.0,8000.0);
        // poison
        TriangularRNG zasielkyVAute = new TriangularRNG(1000.0, 2500.0,3500.0);
        double pocetStihnuti = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5475; j++) {
                double pocetListov = 0;
                double pocetAut = 0; // tuto je ten poison
                for (int k = 0; k < pocetAut; k++) {
                    pocetListov += zasielkyVAute.sample();
                }
                for (int k = 0; k < 3; k++) { // to sú tie hodiny
                    pocetListov -= spracovanieListov.sample();
                }
                if (pocetListov <= 0) {
                    pocetStihnuti++;
                }
            }
        }
        

        System.out.println("Pr že stihne je: " + pocetStihnuti/54750);
    }
}
