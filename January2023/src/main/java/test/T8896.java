package test;

import java.util.HashMap;
import java.util.Hashtable;

public class T8896 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(7);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(8);
        hashtable.put(2,2);
        Integer uuuuu=8;
        int i = uuuuu.hashCode();
        System.out.println(i);
        hashMap.put(1, 1);
        System.out.println(hashMap);

    }
}
