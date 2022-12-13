import OSPRNG.TriangularRNG;

public class Pr_7 {
    public static int naSklade = 5585; // 5500, 5560
    public static final int nakladyLietadlo = 150;
    public static final int strataVakciny = 50;
    public static final int pocetReplikacii = 10000000;

    public static void main(String[] args) {
        TriangularRNG dopyt = new TriangularRNG(1000.0, 4000.0, 8500.0);
        double oldStrata = Double.MAX_VALUE;
        int spravnaVelkost = 0;
        boolean pokacuj = true;
        while (pokacuj) {
            double strata = 0;
            for (int i = 0; i < pocetReplikacii; i++) {
                int dopytMesiac = (int) Math.ceil(dopyt.sample());
                int naDodanie = 0;
                int prebytocne = 0;
                if (dopytMesiac >= naSklade) {
                    naDodanie = dopytMesiac - naSklade;
                } else {
                    prebytocne = naSklade - dopytMesiac;
                }
                strata += (naDodanie * nakladyLietadlo) + (prebytocne * strataVakciny);
            }
            strata /= pocetReplikacii;
            System.out.println(naSklade + " strata " + strata);
            // postupným znižovanim intrevalu sa viem priblížiť cielu
            if (strata < oldStrata) {
                oldStrata = strata;
                spravnaVelkost = naSklade;
                //naSklade += 1000;
                //naSklade += 500;
                //naSklade += 250;
                //naSklade += 125;
                //naSklade += 60;
                //naSklade += 30;
                //naSklade += 10;
                //naSklade += 5;
                naSklade += 1;
            } else {
                pokacuj = false;
            }
        }
        System.out.println("Velkost skladu: " + spravnaVelkost);
        //103279.65066 - 5530
        //103187.73931
    }

}
