import OSPRNG.UniformDiscreteRNG;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class SpracovanieDat {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> diagram = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        UniformDiscreteRNG random = new UniformDiscreteRNG(1,60);
        while (scanner.hasNext()) {
            int cislo = scanner.nextInt();
            cislo *= 60;
            cislo += random.sample();
            if (cislo == 0) {
                cislo = 1;
            }
            if (!diagram.containsKey(cislo)) {
                diagram.put(cislo, 1);
            } else {
                int tmpCislo = diagram.get(cislo);
                diagram.replace(cislo, tmpCislo+1);
            }
            System.out.println(cislo);
        }
/*
        for (Integer integer : diagram.keySet()) {
            System.out.printf("%d: %d\n", integer, diagram.get(integer));
        }
        /*
        for (int i = 1; i < 420; i+=(420/11)) {
            System.out.println(i);
        }*/
    }
}
