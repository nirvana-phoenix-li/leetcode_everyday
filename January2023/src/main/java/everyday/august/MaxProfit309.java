package everyday.august;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 * 中等
 * 1.6K
 * 相关企业
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 通过次数
 * 290K
 * 提交次数
 * 448.4K
 * 通过率
 * 64.7%
 */
public class MaxProfit309 {
    public static void main(String[] args) {


    }

    public int maxProfit(int[] prices) {
        int[][] dpHelp = new int[prices.length + 1][2];
        dpHelp[0][0] = 0;
        dpHelp[0][1] = Integer.MIN_VALUE;
        
        for (int i = 1; i <= prices.length; i++) {
            //0代表没有股票。1代表有股票
            dpHelp[i][0] = Math.max(dpHelp[i - 1][0], dpHelp[i - 1][1] + prices[i - 1]);

            dpHelp[i][1] = Math.max(dpHelp[i - 1][1], dpHelp[i - 1][0] - prices[i - 1]);
        }
        return dpHelp[prices.length][0];
    }
}
