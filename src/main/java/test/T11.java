package test;

import java.util.*;

public class T11 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("flink");
        arrayList.add("dfa");
        arrayList.add("neo4j");
        int i = new Random().nextInt(arrayList.size());
        System.out.println(arrayList.get(i));

    }


}
