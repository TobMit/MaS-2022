import OSPRNG.UniformDiscreteRNG;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SpracovanieDat {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> diagram = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        //UniformDiscreteRNG random = new UniformDiscreteRNG(1,60);
        while (scanner.hasNext()) {
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(),":");
            int cislo = Integer.parseInt(stringTokenizer.nextToken());
            int cislo2 = Integer.parseInt(stringTokenizer.nextToken());
            cislo *= 60;
            cislo += cislo2;
//            if (cislo == 0) {
//                cislo = 1;
//            }
//            if (!diagram.containsKey(cislo)) {
//                diagram.put(cislo, 1);
//            } else {
//                int tmpCislo = diagram.get(cislo);
//                diagram.replace(cislo, tmpCislo+1);
//            }
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
