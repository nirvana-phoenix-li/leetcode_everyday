package utils;

public class BracketsCovertUtils {

    public static void main(String[] args) {
        String input="[[-17,-6],[-4,0],[-2,-16],[-1,2],[0,11],[6,18]]";

        String covert = covert(input);
        System.out.println(covert);


    }

    private static String covert(String input) {
        String replace = input.replace("[", "{").replace("]", "}");
        return replace;
    }
}
