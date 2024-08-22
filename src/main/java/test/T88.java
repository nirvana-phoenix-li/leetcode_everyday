package test;

public class T88 {
    public static void main(String[] args) {


        String s1 = "7364289578247524";
        String s2 = "7364289578247524";
        String calculate = calculate(s1, s2);
        System.out.println(calculate);

    }

    private static String calculate(String input, String next) {
        int length1 = input.length();
        int length2 = next.length();
        int maxLength = Math.max(length1, length2);
        int temp = 0;

        boolean isAdd = false;
        StringBuilder sb = new StringBuilder();
        while (temp < maxLength) {
            int index1 = length2 - temp - 1;
            int first = 0;
            if (index1 >= 0) {
                first = next.charAt(index1) - 48;
            }
            int index2 = length1 - temp - 1;
            int second = 0;
            if (index2 >= 0) {
                second = input.charAt(index2) - 48;
            }
            int answer = first + second;
            if (isAdd) {
                answer++;
            }
            if (answer > 9) {
                isAdd = true;
            } else {
                isAdd = false;
            }

            sb.insert(0, answer % 10);
            temp++;
        }

        if (isAdd){
            sb.insert(0, 1);
        }
        return sb.toString();

    }

}
