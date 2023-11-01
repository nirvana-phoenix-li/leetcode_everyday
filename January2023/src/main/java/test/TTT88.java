package test;

public class TTT88 {
    public static void main(String[] args) {
        int[] nums = {20, 12, 27, 9, 25, 40, 19, 1, 21};

        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    res += nums[k];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        System.out.println(res);
    }
}
