package test;

import java.time.LocalDateTime;
import java.util.HashSet;

public class T8888 {
    public static void main(String[] args) throws InterruptedException {
        int a = 'A';
        System.out.println(a);
        int a1 = 'Z';
        System.out.println(a1);

        int b = '0';
        System.out.println(b);

        int b1 = '9';
        System.out.println(b1);

        String ffff = "j无法不是女都搜吧";
        System.out.println(ffff.charAt(3));

        System.out.println(LocalDateTime.now().toString());

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        System.out.println(hashSet.toString());
    }
}
