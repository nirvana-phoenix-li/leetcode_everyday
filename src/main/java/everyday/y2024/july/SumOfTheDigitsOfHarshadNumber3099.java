package everyday.y2024.july;


/**
 * 3099. 哈沙德数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： x = 18
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： x = 23
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 100
 */
public class SumOfTheDigitsOfHarshadNumber3099 {
    public static void main(String[] args) {
        SumOfTheDigitsOfHarshadNumber3099 main = new SumOfTheDigitsOfHarshadNumber3099();
        int i = main.sumOfTheDigitsOfHarshadNumber(18);
        System.out.println(i);
    }

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int ans = 0;
        int original = x;
        while (x != 0) {
            ans += x % 10;
            x /= 10;
        }


        return original % ans == 0 ? ans : -1;
    }
}
