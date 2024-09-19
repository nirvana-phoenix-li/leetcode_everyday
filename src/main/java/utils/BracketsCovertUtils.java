package utils;

public class BracketsCovertUtils {

    public static void main(String[] args) {
        String input = "[[3,6],[1,5],[4,7]]";

        String covert = covert(input);
        System.out.println(covert);


    }

    private static String covert(String input) {
        String replace = input.replace("[", "{").replace("]", "}");
        return replace;
    }


}
