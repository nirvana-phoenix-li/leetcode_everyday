package test;

import java.time.LocalDateTime;

public class T77 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime one = now.plusHours(1);
        LocalDateTime two = now.plusHours(2);
        System.out.println(now);
        System.out.println(one);
        System.out.println(two);
    }
}
