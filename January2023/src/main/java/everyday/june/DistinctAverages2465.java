package everyday.june;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2465. 不同的平均值数目
 * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
 * <p>
 * 只要 nums 不是 空数组，你就重复执行以下步骤：
 * <p>
 * 找到 nums 中的最小值，并删除它。
 * 找到 nums 中的最大值，并删除它。
 * 计算删除两数的平均值。
 * 两数 a 和 b 的 平均值 为 (a + b) / 2 。
 * <p>
 * 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
 * 返回上述过程能得到的 不同 平均值的数目。
 * <p>
 * 注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,0,3,5]
 * 输出：2
 * 解释：
 * 1. 删除 0 和 5 ，平均值是 (0 + 5) / 2 = 2.5 ，现在 nums = [4,1,4,3] 。
 * 2. 删除 1 和 4 ，平均值是 (1 + 4) / 2 = 2.5 ，现在 nums = [4,3] 。
 * 3. 删除 3 和 4 ，平均值是 (3 + 4) / 2 = 3.5 。
 * 2.5 ，2.5 和 3.5 之中总共有 2 个不同的数，我们返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,100]
 * 输出：1
 * 解释：
 * 删除 1 和 100 后只有一个平均值，所以我们返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * nums.length 是偶数。
 * 0 <= nums[i] <= 100
 * 通过次数16,816提交次数23,318
 */
public class DistinctAverages2465 {
    public static void main(String[] args) {
        DistinctAverages2465 main = new DistinctAverages2465();
        int[] ints = {4, 1, 4, 0, 3, 5};
        int i = main.distinctAverages(ints);
        System.out.println(i);

    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length/2; i++) {
            int i1 = nums[i] + nums[nums.length - i - 1];
            hashSet.add(i1);
        }
        return hashSet.size();
    }
}
