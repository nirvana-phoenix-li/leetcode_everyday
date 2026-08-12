package everyday.y2026.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 3731. 找出缺失的元素
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，数组由若干 互不相同 的整数组成。
 * <p>
 * 数组 nums 原本包含了某个范围内的 所有整数 。但现在，其中可能 缺失 部分整数。
 * <p>
 * 该范围内的 最小 整数和 最大 整数仍然存在于 nums 中。
 * <p>
 * 返回一个 有序 列表，包含该范围内缺失的所有整数，并 按从小到大排序。如果没有缺失的整数，返回一个 空 列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,4,2,5]
 * <p>
 * 输出： [3]
 * <p>
 * 解释：
 * <p>
 * 最小整数为 1，最大整数为 5，因此完整的范围应为 [1,2,3,4,5]。其中只有 3 缺失。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [7,8,6,9]
 * <p>
 * 输出： []
 * <p>
 * 解释：
 * <p>
 * 最小整数为 6，最大整数为 9，因此完整的范围为 [6,7,8,9]。所有整数均已存在，因此没有缺失的整数。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [5,1]
 * <p>
 * 输出： [2,3,4]
 * <p>
 * 解释：
 * <p>
 * 最小整数为 1，最大整数为 5，因此完整的范围应为 [1,2,3,4,5]。缺失的整数为 2、3 和 4。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 5,808/6.9K
 * 通过率
 * 84.6%
 */
public class FindMissingElements3731 {
    public static void main(String[] args) {
        FindMissingElements3731 main = new FindMissingElements3731();
        int[] ints = {5, 1};
        List<Integer> missingElements = main.findMissingElements(ints);
        System.out.println(missingElements);

        Date date = new Date();
        System.out.println(date);
    }

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (++before != nums[i]) {
                list.add(before);
            }
            before = nums[i];
        }
        return list;
    }
}
