package everyday.y2022.june;

import java.util.HashMap;

/**
 * 2475. 数组中不等三元组的数目
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 通过次数17,370提交次数22,342
 */
public class UnequalTriplets2475 {
    public static void main(String[] args) {
        UnequalTriplets2475 main = new UnequalTriplets2475();
        int[] ints = {1,3,1,2,4};
//        [1,3,1,2,4]
//        [1,3,1,2,4]
        int i = main.unequalTriplets(ints);
        System.out.println(i);
    }

    public int unequalTriplets(int[] nums) {
        int size = nums.length;
        int all = countTripleC(size);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        if (hashMap.size() < 3) return 0;
        for (Integer value : hashMap.values()) {
            if (value >= 2) {
                all = all-   (value * (value - 1) / 2) *( size - value)-countTripleC(value);
            }
        }
        return all;
    }

    private int countTripleC(int input) {
        return input * (input - 1) * (input - 2) / 6;
    }
}
