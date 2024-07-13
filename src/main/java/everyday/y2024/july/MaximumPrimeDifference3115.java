package everyday.y2024.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 3115. 质数的最大距离
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4,2,9,5,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,8,2,8]
 * <p>
 * 输出： 0
 * <p>
 * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 105
 * 1 <= nums[i] <= 100
 * 输入保证 nums 中至少有一个质数。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 19.4K
 * 提交次数
 * 30.3K
 * 通过率
 * 63.9%
 */
public class MaximumPrimeDifference3115 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 2; i < 101; i++) {
            boolean isPrime = true;
            for (int j = 0; j < integers.size(); j++) {
                if (i % integers.get(j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                integers.add(i);
            }
        }

        System.out.println(integers);
    }

    public int maximumPrimeDifference(int[] nums) {

        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (list.contains(num)) {
                nums[i] = 0;
            }
        }

        int firstPrime = -1;
        int lastPrime = -1;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstPrime = i;
                break;
            }
        }

        for (int z = nums.length - 1; z >= 0; z--) {

            if (nums[z] == 0) {
                lastPrime = z;
                break;
            }
        }

        return lastPrime - firstPrime;
    }
}
