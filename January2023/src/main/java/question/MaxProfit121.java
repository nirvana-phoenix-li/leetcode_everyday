package question;

/**
 * 121. 买卖股票的最佳时机
 * 简单
 * 3.2K
 * 相关企业
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * 通过次数
 * 1.2M
 * 提交次数
 * 2.1M
 * 通过率
 * 57.8%
 */
public class MaxProfit121 {
    public static void main(String[] args) {
        MaxProfit121 main = new MaxProfit121();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = main.maxProfit(ints);
        System.out.println(i);

    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i]) {
                profit = Math.max(profit, prices[i - 1] - minValue);
                minValue = Math.min(minValue, prices[i]);
            }
        }
        profit = Math.max(profit, prices[prices.length- 1] - minValue);

        return profit == 0 && prices[1] - prices[0] > 0 ? prices[prices.length - 1] - prices[0] : profit;
    }
}
