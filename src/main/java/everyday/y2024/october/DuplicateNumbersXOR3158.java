package everyday.y2024.october;

import java.util.HashSet;

public class DuplicateNumbersXOR3158 {
    public static void main(String[] args) {
    }

    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                ans ^= num;
            } else {
                hashSet.add(num);
            }
        }
        return ans;
    }
}
