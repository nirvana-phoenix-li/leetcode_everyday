package test;

public class Hello {
    volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        String sss = "sul水水水水你是";
        int length = sss.length();
        System.out.println(length);
        char c = sss.charAt(length - 1);
        System.out.println(c);

    }
}