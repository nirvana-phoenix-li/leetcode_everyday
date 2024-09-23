package everyday.y2024.september;


/**
 * 1014. 最佳观光组合
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 69.3K
 * 提交次数
 * 119.8K
 * 通过率
 * 57.8%
 */
public class MaxScoreSightseeingPair1014 {
    public static void main(String[] args) {
        MaxScoreSightseeingPair1014 main = new MaxScoreSightseeingPair1014();
        int[] ints = {2, 10, 9, 3, 2};
        int i = main.maxScoreSightseeingPair(ints);
        System.out.println(i);

    }

    public int maxScoreSightseeingPair(int[] values) {

        int preIndex = 0;
        int preValue = values[0];
        int beforeValue = -1;
        int beforeIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < values.length; j++) {
            if (beforeValue == -1) {
                beforeValue = values[j];
                beforeIndex = j;
                int temp = preValue + beforeValue - 1;
                max = Math.max(max, temp);

            } else {
                int pre = preValue + values[j] + preIndex - j;
                int before = beforeValue + values[j] + beforeIndex - j;
                if (before > pre) {
                    preIndex = beforeIndex;
                    preValue = beforeValue;
                }
                beforeIndex = j;
                beforeValue = values[j];

                max = Math.max(max, pre);
                max = Math.max(max, before);
            }
        }
        return max;
    }
}
