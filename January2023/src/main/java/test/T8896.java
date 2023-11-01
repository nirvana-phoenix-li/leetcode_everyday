package test;

public class T8896 {

    public static void main(String[] args) {
        int help = 1;
        while (true) {
            if (help % 17 != 0) {
                help = help * 10 + 1;
            } else {
                System.out.println(help);
                break;
            }
        }
    }
}
