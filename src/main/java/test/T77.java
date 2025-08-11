package test;


import java.util.HashSet;

public class T77 {
    public static void main(String[] args) {

        double v = 13 / 16d;

        System.out.println(v);

    }

    private static void extracted(String s, HashSet<String> hashSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                continue;
            } else if (s.charAt(i) == ',' || s.charAt(i) == ']') {
                hashSet.add(sb.toString());
                sb = new StringBuilder();
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
    }
}
