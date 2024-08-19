package contest.week411;

public class T1 {
    public static void main(String[] args) {
        T1 main = new T1();
        String[] strings = {"hey", "aeo", "mu", "ooo", "artro"};


    }

    public  int countKConstraintSubstrings(String s, int k) {
        int count0 = 0;
        int count1 = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }

            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }

            result += (right - left + 1);
        }

        return result;
    }


}
