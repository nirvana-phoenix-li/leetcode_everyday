package everyday.y2024.august;

import java.util.HashMap;


/**
 * 3153. 所有数对中数位不同之和
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * <p>
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 * <p>
 * 请你返回 nums 中 所有 整数对里，数位不同之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [13,23,12]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 计算过程如下：
 * - 13 和 23 的数位不同为 1 。
 * - 13 和 12 的数位不同为 1 。
 * - 23 和 12 的数位不同为 2 。
 * 所以所有整数数对的数位不同之和为 1 + 1 + 2 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,10,10,10]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] < 109
 * nums 中的整数都有相同的数位长度。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 7.3K
 * 提交次数
 * 12.8K
 * 通过率
 */
public class SumDigitDifferences3153 {
    public static void main(String[] args) {
        SumDigitDifferences3153 main = new SumDigitDifferences3153();
        int[] ints = {10, 10, 10, 10};

        long l = main.sumDigitDifferences(ints);
        System.out.println(l);

    }

    public long sumDigitDifferences(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                total += getDiffNumber(nums[i], nums[j]);
            }
        }
        return total;
    }

    private Integer getDiffNumber(int first, int second) {
        int count = 0;
        while (first != 0) {
            if (first % 10 != second % 10) {
                count++;
            }
            first /= 10;
            second /= 10;
        }
        return count;
    }


    public long sumDigitDifferences2(int[] nums) {

        int baseValue = 1;
        HashMap<Integer, Integer>[] arr = new HashMap[String.valueOf(nums[0]).length()];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            while (num != 0) {
                int temp = num % 10;
                if (arr[count] == null) {
                    arr[count] = new HashMap<>();
                }
                HashMap<Integer, Integer> integerIntegerHashMap = arr[count];
                if (integerIntegerHashMap.containsKey(temp)) {
                    integerIntegerHashMap.put(temp, integerIntegerHashMap.get(temp) + 1);
                } else {
                    integerIntegerHashMap.put(temp, 1);
                }
                count++;
                num /= 10;
            }
        }
        for (HashMap<Integer, Integer> integerIntegerHashMap : arr) {
            if (integerIntegerHashMap.size() != 1) {
                for (Integer value : integerIntegerHashMap.values()) {
                    baseValue *= value;
                }
            }
        }
        return baseValue == 1 ? 0 : baseValue;
    }


}
