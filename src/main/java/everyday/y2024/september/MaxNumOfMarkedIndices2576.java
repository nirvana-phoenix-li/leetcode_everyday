package everyday.y2024.september;

import java.util.Arrays;

/**
 * 2576. 求出最多标记下标
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
 * <p>
 * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
 * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,4]
 * 输出：2
 * 解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
 * 没有其他更多可执行的操作，所以答案为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [9,2,5,4]
 * 输出：4
 * 解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
 * 第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
 * 没有其他更多可执行的操作，所以答案为 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [7,6,8]
 * 输出：0
 * 解释：没有任何可以执行的操作，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 18.8K
 * 提交次数
 * 40.2K
 * 通过率
 * 46.7%
 */
public class MaxNumOfMarkedIndices2576 {

    public static void main(String[] args) {
        MaxNumOfMarkedIndices2576 main = new MaxNumOfMarkedIndices2576();
        int[] ints = {3,5,2,4};
        int i = main.maxNumOfMarkedIndices(ints);
        System.out.println(i);
    }
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = (nums.length + 1) / 2;
        int count = 0;
        while (left <= nums.length / 2 && right <= nums.length - 1) {
            if (2 * nums[left] <= nums[right]) {
                count+=2;
                left++;
                right++;
            }else {
                right++;
            }

        }
        return count;
    }
}
