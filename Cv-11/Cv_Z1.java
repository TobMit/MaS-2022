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
        TriangularRNG cenaDennejTlace = new TriangularRNG(0.25, 0.95, 0.6);
        UniformContinuousRNG dlzkaPracovnejDoby = new UniformContinuousRNG(250.0, 420.0);
        // kolko balikov nakupovať aby dosiahol zisk?  (15)
        // Aký denný zisk dosiahne kolportér pri doporučenom nakupe balikov?(54.6)
        long pocetPredanychNovin = 0;
        double zisk = 0;
        //int pocetBalickov  = 0;
        for (int i = 0; i <= pocetReplikacii; i++) {
            double pracovnaDoba = dlzkaPracovnejDoby.sample();
            int pocetPredanychNovynZaDen = (int) Math.ceil(pracovnaDoba / intervalMedziPredajmi);
            //int pocetBalickovZaDen = 0;
            pocetPredanychNovin += pocetPredanychNovynZaDen;
            if (pocetBalikov * velkostBalika < pocetPredanychNovynZaDen) {
                pocetPredanychNovynZaDen = pocetBalikov * velkostBalika;
            }
            /*
            if (pocetPredanychNovynZaDen % 10 == 0) {
                pocetBalickovZaDen = pocetPredanychNovynZaDen / 10;

            } else {
                pocetBalickovZaDen = pocetPredanychNovynZaDen / 10 + 1;
            }
            pocetBalickov += pocetBalickovZaDen;*/
            double dennnyZik = ziskFun(pocetPredanychNovynZaDen, pocetBalikov, cenaDennejTlace.sample());
            //System.out.println(dennnyZik);
            zisk +=dennnyZik;

        }

        //System.out.printf("Priemerny pocet balickov %f\n",(double) pocetBalickov / pocetReplikacii);
        System.out.printf("Primerny pocet zisku %f\n", zisk / pocetReplikacii );
        System.out.printf("Priemerny pocet predanych novyn za den %f", (double)pocetPredanychNovin / pocetReplikacii);

    }

    private static double ziskFun(int pocetPredanychNovynZaDen, int pocetBalickovZaDen, double cenaPredaja) {
        //return cenaPredaja * pocetPredanych + (cenaVratenia * (velkostobjednavky - pocetPredanych)) - (nakupnaCena * velkostobjednavky);
        return cenaPredaja * pocetPredanychNovynZaDen - (cenaTlace * (pocetBalickovZaDen * velkostBalika)) + (cenaVratenejTlace * ((pocetBalickovZaDen * velkostBalika) - pocetPredanychNovynZaDen));
    }
}
