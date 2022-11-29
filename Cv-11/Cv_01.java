import OSPRNG.*;
public class Cv_01 {
    private static double HV = 0; // hospodársky vysledok
    private static double nakupnaCena = 0.6;
    private static double cenaPredaja = 0.89;
    private static double cenaVratenia = 0;
    private static double velkostobjednavky = 80;
    private static double pocetPredanych = 0;

    public static void main(String[] args) {
        int n = 10000;
        double m = 0;
        UniformContinuousRNG uniform = new UniformContinuousRNG(0.4, 0.7);
        TriangularRNG triangularRNG = new TriangularRNG(70.0, 80.0, 110.0);
        for (int i = 0; i < n; i++) {
            nakupnaCena = uniform.sample();
            cenaVratenia = nakupnaCena/2;
            double dopyt = triangularRNG.sample();
            pocetPredanych = Math.min(velkostobjednavky, dopyt);
            m += spocitajZisk();
        }
        HV = m/n;
        System.out.printf("Zisk je %f / %d = %f", m, n, HV);
    }

    private static double spocitajZisk() {
        return cenaPredaja * pocetPredanych + (cenaVratenia * (velkostobjednavky - pocetPredanych)) - (nakupnaCena * pocetPredanych);
    }
}
