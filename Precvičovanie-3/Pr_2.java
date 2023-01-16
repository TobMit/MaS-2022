import OSPRNG.TriangularRNG;
import OSPRNG.UniformDiscreteRNG;

public class Pr_2 {
    public static int pocetA = 70;
    public static int pocetB = 90;
    public static final int pocetReplikacii = 1000000;
    public static final int cenaA = 3;
    public static final int cenaB = 2;
    public static void main(String[] args) {
        TriangularRNG nakladyA = new TriangularRNG(1.0, 1.75, 2.5 );
        TriangularRNG nakladyB = new TriangularRNG(0.7, 1.2, 1.7 );
        UniformDiscreteRNG dopytA = new UniformDiscreteRNG(40 , 79);
        UniformDiscreteRNG dopytB = new UniformDiscreteRNG(66 , 154);
        double zarobokA = 0;
        double zarobokB = 0;
        for (int i = 0; i < pocetReplikacii; i++) {
            double aktualneNakladyA = nakladyA.sample();
            double aktualneNakladyB = nakladyB.sample();
            double aktalnyDopytA = Math.min(pocetA, dopytA.sample());
            double aktalnyDopytB = Math.min(pocetB, dopytB.sample());
            zarobokA += aktalnyDopytA * cenaA - aktualneNakladyA * pocetA;
            zarobokB += aktalnyDopytB * cenaB - aktualneNakladyB * pocetB;
        }
        System.out.printf("Tovar A: priemerna cena: %f\n", zarobokA / pocetReplikacii);
        System.out.printf("Tovar A: priemerna cena: %f", zarobokB / pocetReplikacii);
    }
}
