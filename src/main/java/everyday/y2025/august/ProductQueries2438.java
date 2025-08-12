package everyday.y2025.august;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2438. 二的幂数组中查询范围内的乘积
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
 * <p>
 * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个 answers[i] 都对 109 + 7 取余 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
 * 输出：[2,4,64]
 * 解释：
 * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
 * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
 * 第 2 个查询的答案：powers[2] = 4 。
 * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
 * 每个答案对 109 + 7 取余得到的结果都相同，所以返回 [2,4,64] 。
 * 示例 2：
 * <p>
 * 输入：n = 2, queries = [[0,0]]
 * 输出：[2]
 * 解释：
 * 对于 n = 2, powers = [2] 。
 * 唯一一个查询的答案是 powers[0] = 2 。答案对 109 + 7 取余后结果相同，所以返回 [2] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 1 <= queries.length <= 105
 * 0 <= starti <= endi < powers.length
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 15,193/29.8K
 * 通过率
 * 50.9%
 */
public class ProductQueries2438 {


    public static void main(String[] args) {
        ProductQueries2438 main = new ProductQueries2438();
        int[][] ints = {{0, 1}, {2, 2}, {0, 3}};
        int[] ints1 = main.productQueries(15, ints);
        System.out.println(Arrays.toString(ints1));

    }

    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int temp = 1;
        int counter = 0;
        while (temp <= n) {
            if ((temp & n) == temp) {
                arrayList.add(counter);
            }
            temp *= 2;
            counter++;

        }
        int[] resultArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int helpCount=0;
            for (int j = first; j <= second; j++) {
                helpCount+=arrayList.get(j);
            }
            int original = 1 << helpCount;
            resultArr[i] = original%(1000*1000*1000+7);

        }
        return resultArr;
    }
}
