import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;
import OSPRNG.UniformDiscreteRNG;

public class Pr_3 {
    public static final double r = 0.5;
    public static final double xKruhu = 0.5;
    public static final double yKruhu = 0.5;
    public static void main(String[] args) {
        boolean najdene = false;
        UniformContinuousRNG randomX = new UniformContinuousRNG();
        UniformContinuousRNG randomY = new UniformContinuousRNG();

        double pocetPadnutych = 0;

        // toto je na zaokruhľovanie -  takto si zýskam presne čislo zaokrúhlené na 6 desatinných miest
        // nie je to ideálne ale funguje
        String tmp = String.format("%.6f", Math.PI);
        double pi = Double.parseDouble(tmp);

        double pocetHdov = 0;

        while (!najdene) {
            pocetHdov++;
            double x = randomX.sample();
            double y = randomY.sample();
            // porovnávam či to padlo
            if ((Math.pow(x - xKruhu, 2) + Math.pow(y - yKruhu, 2)) <= Math.pow(r, 2)) {
                pocetPadnutych++;
            }
            double pseudoPiVypocet = 0;

            if (pocetPadnutych != 0) {
                // premenné musia byť double lebo inak by delenie bolo zaokrúhlené
                pseudoPiVypocet = (pocetPadnutych / pocetHdov) / (r * r);
            }
            // znovu zaokrúhlovanie
            String stringPseudoPi = String.format("%.6f", pseudoPiVypocet);
            double pseudoPi = Double.parseDouble(stringPseudoPi);
            if (pseudoPi == pi) {
                najdene = true;
            }
            System.out.println(pocetHdov + " " + pocetPadnutych + " " + pi + " " + pseudoPi);
        }
        System.out.println(pocetHdov);

    }
}
