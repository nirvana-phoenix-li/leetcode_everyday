package everyday.y2025;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 594. 最长和谐子序列
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * <p>
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [3,2,2,2,3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在和谐子序列。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 111,297/191.9K
 * 通过率
 * 58.0%
 */
public class FindLHS594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> collect = hashMap.keySet().stream().sorted().collect(Collectors.toList());
        if (collect.size() == 1) {
            return 0;
        }


        int maxValue = 0;
        for (int i = 0; i < collect.size()-1; i++) {
            if (collect.get(i)+1 == collect.get(i+1)) {
                int currentMax = hashMap.get(collect.get(i)) + hashMap.get(collect.get(1+i));
                maxValue = Math.max(maxValue, currentMax);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        FindLHS594 main = new FindLHS594();
        int lhs = main.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(lhs);
    }
}
