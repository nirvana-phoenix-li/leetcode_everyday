package everyday.august;

import java.util.Arrays;

/**
 * 2578. 最小和分割
 * 提示
 * 简单
 * 53
 * 相关企业
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= num <= 109
 * 通过次数
 * 21.5K
 * 提交次数
 * 26.1K
 * 通过率
 * 82.3%
 */
public class SplitNum2578 {
    public static void main(String[] args) {
        SplitNum2578 main = new SplitNum2578();
        int i = main.splitNum(687);
        System.out.println(i);
    }

    public int splitNum(int num) {
        String[] split = String.valueOf(num).split("");
        Arrays.sort(split);
        int res = 0;
        int magnification = 1;
        for (int z = split.length - 1; z >= 0; z = z - 2) {
            res += Integer.parseInt(split[z]) * magnification;
            if (z - 1 >= 0) {
                res += Integer.parseInt(split[z - 1]) * magnification;
            }
            magnification *= 10;
        }
        return res;

    }
}
