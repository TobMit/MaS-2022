import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Pr_9 {
    public static void main(String[] args) {
        int pocetOpakovani = 1000000;
        int cenaLetenky = 500;
        int maxNaplnenostLetiska = 75;

        TriangularRNG klesanieCien = new TriangularRNG(1.0, 4.0, 11.0);
        UniformContinuousRNG naplnenieLetiska = new UniformContinuousRNG(5.0, 14.0);
        double priemernyDen = 0;
        double priemernaCena = 0;
        Double[] cena = new Double[6];
        for (int i = 0; i < cena.length; i++) {
            cena[i] = 0.0;
        }
        for (int i = 0; i < pocetOpakovani; i++) {

            double naplnenie = 27;
            double zlava = 0;
            for (int j = 0; j < 6; j++) {
                naplnenie += naplnenieLetiska.sample();
                if (naplnenie >= maxNaplnenostLetiska) {
                    double prepocitanaZlava = (100 - zlava) / 100;
                    double tmpCena = cenaLetenky * prepocitanaZlava;
                    tmpCena *= 1.30;
                    cena[j] += tmpCena;
                }  else {
                    zlava += klesanieCien.sample();
                    double prepocitanaZlava = (100 - zlava) / 100;
                    double tmpCena = cenaLetenky * prepocitanaZlava;
                    cena[j] += tmpCena;
                }

            }

        }
        for (int i = 0; i < cena.length; i++) {
            System.out.println("Den " + i + ". a cena je: " + cena[i]/pocetOpakovani + "€");
        }
        //System.out.println("Cestovatel by mal kupovat lentenku v " + priemernyDen / pocetOpakovani + " za " + priemernaCena / pocetOpakovani);
    }
}
