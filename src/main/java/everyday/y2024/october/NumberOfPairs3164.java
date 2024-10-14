package everyday.y2024.october;

import java.util.HashMap;
import java.util.Map;

/**
 * 3164. 优质数对的总数 II
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 *
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 *
 * 返回 优质数对 的总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 *
 * 输出：5
 *
 * 解释：
 *
 * 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 *
 * 输出：2
 *
 * 解释：
 *
 * 2个优质数对分别是 (3, 0) 和 (3, 1)。
 *
 *
 *
 * 提示：
 *
 * 1 <= n, m <= 105
 * 1 <= nums1[i], nums2[j] <= 106
 * 1 <= k <= 103
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 10.3K
 * 提交次数
 * 27K
 * 通过率
 * 38.0%
 */
public class NumberOfPairs3164 {
    public static void main(String[] args) {
        int[] ints1 = {1, 3, 4};
        int[] ints2 = {1, 3, 4};
        NumberOfPairs3164 main = new NumberOfPairs3164();
        long l = main.numberOfPairs(ints1, ints2, 1);
        System.out.println(l);

    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;
        HashMap<Integer, Integer> sufMap = transform2Map(nums2,k);
        for (int i = 0; i < nums1.length; i++) {
            if (sufMap.containsKey(nums1[i])) {
              count += sufMap.get(nums1[i]);
            }
        }
        return count;
    }

    private HashMap<Integer, Integer> transform2Map(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] * k;
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        return map;
    }
}
