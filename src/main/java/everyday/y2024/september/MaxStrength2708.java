package everyday.y2024.september;

import java.util.Arrays;

/**
 * 2708. 一个小组的最大实力值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 * <p>
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,-1,-5,2,5,-9]
 * 输出：1350
 * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
 * 示例 2：
 * <p>
 * 输入：nums = [-4,-5,-4]
 * 输出：20
 * 解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 13
 * -9 <= nums[i] <= 9
 */
public class MaxStrength2708 {
    public static void main(String[] args) {
        MaxStrength2708 main = new MaxStrength2708();
        int[] ints = {6,-3,-4,8,4,7,6,4,7,7,-3,-6,9};
        long l = main.maxStrength(ints);
        System.out.println(l);
    }

    public long maxStrength(int[] nums) {

        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        long original = 1;
        boolean neverNegative = true;
        boolean flag = false;
        for (int z = nums.length - 1; z >= 0; z--) {
            if (nums[z] > 0) {
                original *= nums[z];
                flag = true;
            } else if (nums[z] == 0) {
            } else {
                if (neverNegative) {
                    neverNegative = false;
                    if (z % 2 == 0) {
                        continue;
                    }
                }
                original *= nums[z];
                flag = true;
            }
        }
        return flag ? original : 0;
    }
}
