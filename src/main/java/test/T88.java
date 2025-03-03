package test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class T88 {
    public static void main(String[] args) {

    }

    private static String calculate(String input) {
        String lowerCase = input.replaceAll("_", "-").toLowerCase();

        return lowerCase;

    }

}
