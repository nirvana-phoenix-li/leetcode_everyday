package test;

import java.util.Random;

public class GiveMeAnswer {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(99);
        if (i>=50){
            System.out.println("macbook");
        }else {
            System.out.println("inter");
        }
        System.out.println(i);
    }
}
