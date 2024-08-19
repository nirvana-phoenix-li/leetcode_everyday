package contest.week411;

public class T3 {
    public static void main(String[] args) {
        T3 main  = new T3();
        String s = main.largestPalindrome(14, 6);
        System.out.println(s);
//
//        8
//        5
    }

    public  String largestPalindrome(int n, int k) {
        long maxHalf = (long)Math.pow(10, (n + 1) / 2) - 1;
        long minHalf = (long)Math.pow(10, (n - 1) / 2);

        for (long half = maxHalf; half >= minHalf; half--) {
            String s = Long.toString(half);
            String reversedS = new StringBuilder(s.substring(0, n / 2)).reverse().toString();
            long palindrome = Long.parseLong(s + reversedS);
            if (palindrome % k == 0) {
                return Long.toString(palindrome);
            }

        }

        return "";
    }
}
