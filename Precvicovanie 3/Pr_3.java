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
        long pocetPadnutych = 0;
        String tmp = String.format("%.6f", Math.PI);
        double pi = Double.parseDouble(tmp);
        while (!najdene) {
            double x = randomX.sample();
            double y = randomY.sample();
            if ((Math.pow(x - xKruhu, 2) + Math.pow(y - yKruhu, 2)) <= Math.pow(r, 2)) {
                pocetPadnutych++;
            }

        }
        System.out.println(Math.PI);
        //String tmp = String.format("%.6f", Math.PI);
        System.out.println(tmp);
        System.out.printf("%f", Math.pow(10,-6));
    }
}
