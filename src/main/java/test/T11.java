package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T11 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        injectList(list);
        for (String s : list) {
            System.out.println(s);
        }

    }

    private static void injectList(List<String> list) {
        list.add("a");

    }
}
