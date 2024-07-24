package utils;

public class BracketsCovertUtils {

    public static void main(String[] args) {
        String input="[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]";

        String covert = covert(input);
        System.out.println(covert);


    }

    private static String covert(String input) {
        String replace = input.replace("[", "{").replace("]", "}");
        return replace;
    }
}
