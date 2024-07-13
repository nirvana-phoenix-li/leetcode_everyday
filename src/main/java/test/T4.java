package test;

import java.util.Arrays;
import java.util.Random;

public class T4 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int[] ints = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
        Arrays.sort(ints);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
