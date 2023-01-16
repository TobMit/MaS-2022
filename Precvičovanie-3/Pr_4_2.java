import OSPRNG.UniformContinuousRNG;

public class Pr_4_2 {
    private static final int pocetKrokov = 1000;
    private static final int pocetReplikacii = 100000;
    public static void main(String[] args) {
        double priemernaVzdialenostX = 0;
        double priemernaVzdialenostY = 0;
        // ich knižnica je strašne pomalá
        UniformContinuousRNG random = new UniformContinuousRNG();
        for (int i = 0; i < pocetReplikacii; i++) {
            int vzdialenostOdStreduX = 0;
            int vzdialenostOdStreduY = 0;
            for (int j = 0; j < pocetKrokov; j++) {
                if (random.sample() < 0.5) {
                    if (random.sample() < 0.5) {
                        vzdialenostOdStreduX++;
                    } else {
                        vzdialenostOdStreduX--;
                    }
                } else {
                    if (random.sample() < 0.5) {
                        vzdialenostOdStreduY++;
                    } else {
                        vzdialenostOdStreduY--;
                    }
                }
            }
            priemernaVzdialenostX += Math.abs(vzdialenostOdStreduX);
            priemernaVzdialenostY += Math.abs(vzdialenostOdStreduY);

        }
        //Math.sqrt((Math.pow(first - druhyBod.first, 2 )) + (Math.pow(second - druhyBod.second, 2)));
        priemernaVzdialenostX /= pocetReplikacii;
        priemernaVzdialenostY /= pocetReplikacii;
        double priemernaVzdialenost = priemernaVzdialenostX + priemernaVzdialenostY;
        double ohadKrokov = Math.sqrt((4*pocetKrokov)/(Math.PI));
        System.out.println("Priemerna vzdialenost je: " + priemernaVzdialenost + " teoretická vzdialenost je: " + ohadKrokov);
    }
}
