package everyday.may;

/**
 * 2455. 可被三整除的偶数的平均值
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 *
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 通过次数16,038提交次数25,084
 */
public class AverageValue2455 {
    public static void main(String[] args) {
        AverageValue2455 main = new AverageValue2455();
        int[] ints = {1, 3, 6, 10, 12, 15};
        int i = main.averageValue(ints);
        System.out.println(i);


    }

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) return 0;
        else {
            return sum/count;
        }
    }
}
