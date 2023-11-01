package everyday.january;

/**
 * 1802. 有界数组中指定下标处的最大值
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 * <p>
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 * <p>
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 * 通过次数14,963提交次数42,408
 */
public class MaxValue1802 {
    public static void main(String[] args) {
        MaxValue1802 main = new MaxValue1802();
        int i = main.maxValue(6, 1, 10);
        System.out.println(i);

    }

    public int maxValue(int n, int index, int maxSum) {
        int temp = n;
        int top = 1;
        do {
            top++;
            int left = Math.min(index - 0, top-2);
            int right = Math.min(n - 1 - index, top-2);
            temp = temp + left + 1 + right;
        } while (temp <= maxSum);

        return --top;
    }
}
