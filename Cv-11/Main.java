import OSPRNG.*;
public class Main {
    public static void main(String[] args) {
        TriangularRNG genNahCislo = new TriangularRNG(15.0, 25.0, 35.0);
        double nahodneCislo = genNahCislo.sample();
        System.out.println("Nahodne čislo: " + nahodneCislo);
    }
}
