package everyday.y2024.october;


/**
 * 910. 最小差值 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * <p>
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * <p>
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 104
 * 0 <= k <= 104
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 19.9K
 * 提交次数
 * 49.4K
 * 通过率
 * 40.3%
 */
public class SmallestRangeII910 {
    public static void main(String[] args) {
        SmallestRangeII910 main = new SmallestRangeII910();
        int[] ints = {1, 3, 6};

//        [1,3,6], k = 3
        int i = main.smallestRangeII(ints, 3);
        System.out.println(i);


    }

    public int smallestRangeII(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        if(max - min > k){
            return Math.abs(max - min-2*k);
        }else {
            return max - min;
        }


    }
}
