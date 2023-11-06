package everyday.y2023.november;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 105
 * 0 <= nums[i] <= 231 - 1
 * 通过次数
 * 54.2K
 * 提交次数
 * 90.4K
 * 通过率
 * 60.0%
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 * 社招
 * 校招
 * 实习
 * 未遇到
 */
public class FindMaximumXOR421 {
    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < 31; i++) {
            hashMap.put(i, new HashSet<Integer>());
        }
        for (int num : nums) {
            int help = 0;
            int temp = num;
            while (temp != 0) {
                int i = temp % 2;
                if (i == 1) {
                    hashMap.get(help).add(num);
                }
                help++;
                temp /= 2;
            }
        }

        for (int z = 30; z >= 0; z--) {
            if (hashMap.get(z).size() != 0) {

            }
        }
        return 0;

    }
}
