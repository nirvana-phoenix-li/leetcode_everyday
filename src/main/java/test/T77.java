package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class T77 {
    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(3);
        hashSet.remove(2);
        System.out.println(hashSet);
    }
}
