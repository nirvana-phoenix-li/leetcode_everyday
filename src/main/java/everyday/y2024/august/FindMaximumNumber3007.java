package everyday.y2024.august;


/**
 * 3007. 价值和小于等于 K 的最大数字
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 k 和一个整数 x 。整数 num 的价值是它的二进制表示中在 x，2x，3x 等位置处
 * 设置位
 * 的数目（从最低有效位开始）。下面的表格包含了如何计算价值的例子。
 * <p>
 * x	num	Binary Representation	Price
 * 1	13	000001101	3
 * 2	13	000001101	1
 * 2	233	011101001	3
 * 3	13	000001101	1
 * 3	362	101101010	2
 * <p>
 * <p>
 * num 的 累加价值 是从 1 到 num 的数字的 总 价值。如果 num 的累加价值小于或等于 k 则被认为是 廉价 的。
 * <p>
 * 请你返回 最大 的廉价数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 9, x = 1
 * 输出：6
 * 解释：由下表所示，6 是最大的廉价数字。
 * x	num	Binary Representation	Price	Accumulated Price
 * 1	1	001	1	1
 * 1	2	010	1	2
 * 1	3	011	2	4
 * 1	4	100	1	5
 * 1	5	101	2	7
 * 1	6	110	2	9
 * 1	7	111	3	12
 * 示例 2：
 * <p>
 * 输入：k = 7, x = 2
 * 输出：9
 * 解释：由下表所示，9 是最大的廉价数字。
 * x	num	Binary Representation	Price	Accumulated Price
 * 2	1	0001	0	0
 * 2	2	0010	1	1
 * 2	3	0011	1	2
 * 2	4	0100	0	2
 * 2	5	0101	0	2
 * 2	6	0110	1	3
 * 2	7	0111	1	4
 * 2	8	1000	1	5
 * 2	9	1001	1	6
 * 2	10	1010	2	8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1015
 * 1 <= x <= 8
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 4.5K
 * 提交次数
 * 10.3K
 * 通过率
 * 44.0%
 */
public class FindMaximumNumber3007 {
    public static void main(String[] args) {

    }

    public long findMaximumNumber(long k, int x) {
        return 0;
    }
}
