import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Cv_Z1 {
    public static double cenaTlace = 0.15;
    public static double cenaVratenejTlace = cenaTlace * 0.65;
    public static double intervalMedziPredajmi = 2.7; // prvý výlačok už hneď po otvorení
    public static int velkostBalika = 10;
    public static int pocetReplikacii = 1000000;
    public static int pocetBalikov = 15;

    public static void main(String[] args) {
        TriangularRNG cenaDennejTlace = new TriangularRNG(0.25,0.6, 0.95);
        UniformContinuousRNG dlzkaPracovnejDoby = new UniformContinuousRNG(250.0, 420.0);
        // kolko balikov nakupovať aby dosiahol zisk?  (15)
        // Aký denný zisk dosiahne kolportér pri doporučenom nakupe balikov?(54.6)
        long pocetPredanychNovin = 0;
        double zisk = 0;
        for (int i = 0; i < pocetReplikacii; i++) {
            double pracovnaDoba = dlzkaPracovnejDoby.sample();
            int pocetPredanychNovynZaDen = (int) Math.ceil(pracovnaDoba / intervalMedziPredajmi);
            pocetPredanychNovin += pocetPredanychNovynZaDen;
            double cenaPredaja = cenaDennejTlace.sample();
            double dennnyZik = cenaPredaja * pocetPredanychNovynZaDen - (cenaTlace * (pocetBalikov * velkostBalika)) + (cenaVratenejTlace * ((pocetBalikov * velkostBalika) - pocetPredanychNovynZaDen));;
            zisk +=dennnyZik;

        }

        //System.out.printf("Priemerny pocet balickov %f\n",(double) pocetBalickov / pocetReplikacii);
        System.out.printf("Primerny pocet zisku %f\n", zisk / pocetReplikacii );
        System.out.printf("Priemerny pocet predanych novyn za den %f", (double)pocetPredanychNovin / pocetReplikacii);

    }
}
