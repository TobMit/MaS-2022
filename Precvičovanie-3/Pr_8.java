import OSPRNG.TriangularRNG;

public class Pr_8 {
    public static final int plocha = 300;
    public static final double prPrekorocenie = 10;
    public static final int pracovnyCas = 10;
    public static final int pocetReplikacii = 1000000;
    public static int pocetTrakorov = 1;
    public static void main(String[] args) {
        TriangularRNG traktorCas = new TriangularRNG(1.0,3.0, 3.5); // za hodinu

        while (true) {
            double zozal = 0;
            double vsetko = 0;
            for (int i = 0; i < pocetReplikacii; i++) {
                double zozatePole = 0;
                for (int j = 0; j < pocetTrakorov; j++) {
                    double tmpPlochaZaHodinu = traktorCas.sample();
                    tmpPlochaZaHodinu *= pracovnyCas;
                    zozatePole += tmpPlochaZaHodinu * 2;
                }
                if (zozatePole >= plocha) {
                    zozal++;
                }
                vsetko++;
            }
            double prZePrekroci = 100 - (zozal / vsetko * 100);
            System.out.println("Pravdepodobnost ze prekorcime limit: " + prZePrekroci + " pocet traktorov: " + pocetTrakorov);
            pocetTrakorov++;
            if (prZePrekroci <= prPrekorocenie) {
                break;
            }
        }

    }
}
