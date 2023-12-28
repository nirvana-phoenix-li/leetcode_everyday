package everyday.y2023.november;

/**
 * 421. 数组中两个数的最大异或值
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
 * 47.5K
 * 提交次数
 * 78.2K
 * 通过率
 * 60.7%
 */
public class FindMaximumXOR421 {
    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int i1 = nums[i] ^ nums[j];
                if (i1 > maxVal) {
                    maxVal = i1;
                }
            }
        }
        return maxVal;
    }
}
