package everyday.y2024.september;

/**
 * 3176. 求出最长好子序列 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
 * <p>
 * 请你返回 nums 中 好
 * 子序列
 * 的最长长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,1,3], k = 2
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长好子序列为 [1,2,1,1,3] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,1], k = 0
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长好子序列为 [1,2,3,4,5,1] 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 109
 * 0 <= k <= min(nums.length, 25)
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 9.3K
 * 提交次数
 * 21.7K
 * 通过率
 * 42.9%
 */
public class MaximumLength3176 {
    public static void main(String[] args) {
        MaximumLength3176 main = new MaximumLength3176();
        int[] ints = {1, 2, 1, 1, 3};
        int i = main.maximumLength(ints, 2);
        System.out.println(i);

    }

    public int maximumLength(int[] nums, int k) {
        int before = nums[0];
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != before) {
                if (k > 0) {
                    k--;
                } else {
                    break;
                }
            }
            before=nums[i];
        }
        return Math.min(nums.length, i);
    }
}
