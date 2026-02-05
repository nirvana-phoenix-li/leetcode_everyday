package everyday.y2025.december;

import java.util.ArrayList;

/**
 * 3573. 买卖股票的最佳时机 V
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 prices，其中 prices[i] 是第 i 天股票的价格（美元），以及一个整数 k。
 * <p>
 * 你最多可以进行 k 笔交易，每笔交易可以是以下任一类型：
 * <p>
 * 普通交易：在第 i 天买入，然后在之后的第 j 天卖出，其中 i < j。你的利润是 prices[j] - prices[i]。
 * <p>
 * 做空交易：在第 i 天卖出，然后在之后的第 j 天买回，其中 i < j。你的利润是 prices[i] - prices[j]。
 * <p>
 * 注意：你必须在开始下一笔交易之前完成当前交易。此外，你不能在已经进行买入或卖出操作的同一天再次进行买入或卖出操作。
 * <p>
 * 通过进行 最多 k 笔交易，返回你可以获得的最大总利润。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,7,9,8,2], k = 2
 * <p>
 * 输出: 14
 * <p>
 * 解释:
 * <p>
 * 我们可以通过 2 笔交易获得 14 美元的利润：
 * 一笔普通交易：第 0 天以 1 美元买入，第 2 天以 9 美元卖出。
 * 一笔做空交易：第 3 天以 8 美元卖出，第 4 天以 2 美元买回。
 * 示例 2:
 * <p>
 * 输入: prices = [12,16,19,19,8,1,19,13,9], k = 3
 * <p>
 * 输出: 36
 * <p>
 * 解释:
 * <p>
 * 我们可以通过 3 笔交易获得 36 美元的利润：
 * 一笔普通交易：第 0 天以 12 美元买入，第 2 天以 19 美元卖出。
 * 一笔做空交易：第 3 天以 19 美元卖出，第 4 天以 8 美元买回。
 * 一笔普通交易：第 5 天以 1 美元买入，第 6 天以 19 美元卖出。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= prices.length <= 103
 * 1 <= prices[i] <= 109
 * 1 <= k <= prices.length / 2
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 5,896/10K
 * 通过率
 * 59.2%
 */
public class MaximumProfit3573 {


    public long maximumProfit(int[] prices, int k) {
        long maxProfit = 0;
        ArrayList<Integer> markIndexList = new ArrayList<>();

        markIndexList.add(-1);
        markIndexList.add(prices.length);

        while (k-- > 0) {
            for (int i = 0; i < markIndexList.size(); i = i + 2) {


//                 price = markIndexList[i];

            }

        }

        return maxProfit;
    }
}
