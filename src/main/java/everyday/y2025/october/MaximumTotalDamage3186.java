package everyday.y2025.october;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3186. 施咒的最大总伤害
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个魔法师有许多不同的咒语。
 * <p>
 * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
 * <p>
 * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
 * <p>
 * 每个咒语最多只能被使用 一次 。
 * <p>
 * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：power = [1,1,3,4]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：power = [7,1,6,6]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= power.length <= 105
 * 1 <= power[i] <= 109
 * <p>
 * 通过次数
 * 19,278/50K
 * 通过率
 * 38.6%
 */
public class MaximumTotalDamage3186 {
    public static void main(String[] args) {
        MaximumTotalDamage3186 main = new MaximumTotalDamage3186();

//        [5,9,2,10,2,7,10,9,3,8]
        int[] ints = {5, 9, 2, 10, 2, 7, 10, 9, 3, 8};
        long l = main.maximumTotalDamage(ints);
        System.out.println(l);


    }

    public long maximumTotalDamage(int[] power) {
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i : power) {
            if (hashMap.containsKey((long) i)) {
                hashMap.put((long) i, hashMap.get((long) i) + 1);
            } else {
                hashMap.put((long) i, 1);
            }
        }
        List<Long> collect = hashMap.keySet().stream().sorted().collect(Collectors.toList());
        long[] dp = new long[collect.size()];
        dp[0] = collect.get(0) * hashMap.get(collect.get(0));
        if (collect.size() == 1) {
            return dp[0];
        }

        long towVal = collect.get(1) * hashMap.get(collect.get(1));
        if (collect.get(1) - collect.get(0) > 2) {
            dp[1] = towVal + dp[0];
        } else {
            dp[1] = Math.max(towVal, dp[0]);
        }
        if (collect.size() == 2) {
            return dp[1];
        }

        long threeVal = collect.get(2) * hashMap.get(collect.get(2));
        if (collect.get(2) - collect.get(1) > 2) {
            dp[2] = threeVal + dp[1];
        } else if (collect.get(2) - collect.get(1) <= 2 && collect.get(2) - collect.get(0) > 2) {
            dp[2] = Math.max(threeVal + dp[0], dp[1]);
        } else {
            threeVal = Math.max(threeVal, dp[0]);
            dp[2] = Math.max(threeVal, dp[1]);
        }


        for (int i = 3; i < collect.size(); i++) {
            long curVal = collect.get(i) * hashMap.get(collect.get(i));
            if (collect.get(i) - collect.get(i - 1) > 2) {
                dp[i] = curVal + dp[i - 1];
            } else if (collect.get(i) - collect.get(i - 1) <= 2 && collect.get(i) - collect.get(i - 2) > 2) {
                dp[i] = Math.max(curVal + dp[i - 2], dp[i - 1]);
            } else {
                curVal += dp[i - 3];
                curVal = Math.max(curVal, dp[i - 2]);
                dp[i] = Math.max(curVal, dp[i - 1]);
            }
        }
        return dp[collect.size() - 1];
    }
}