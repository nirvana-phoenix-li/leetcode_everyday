package everyday.may;

/**
 * 1330. 翻转子数组得到最大的数组值
 * 给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
 * <p>
 * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
 * <p>
 * 请你找到可行的最大 数组值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,5,4]
 * 输出：10
 * 解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,9,24,2,1,10]
 * 输出：68
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3*10^4
 * -10^5 <= nums[i] <= 10^5
 * 通过次数3,845提交次数7,392
 */
public class MaxValueAfterReverse1330 {
    public static void main(String[] args) {
        MaxValueAfterReverse1330 main = new MaxValueAfterReverse1330();
        int[] ints = {2, 4, 9, 24, 2, 1, 10};
        int i = main.maxValueAfterReverse(ints);

        System.out.println(i);

    }

    public int maxValueAfterReverse(int[] nums) {
        if (nums.length == 1) return 0;
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = 0;
                if (i != 0) {
                    temp += Math.abs(nums[j] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]);
                }
                if (j != nums.length - 1) {
                    temp += Math.abs(nums[i] - nums[j + 1]) - Math.abs(nums[j] - nums[j + 1]);
                }
                if (temp > maxGap) {
                    maxGap = temp;
//                    System.out.println(i+"!!!"+j+"!!"+maxGap);
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap += Math.abs(nums[i] - nums[i + 1]);
        }
        return maxGap;
    }
}

