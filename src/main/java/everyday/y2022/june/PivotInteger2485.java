package everyday.y2022.june;

/**
 * 2485. 找出中枢整数
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 通过次数22,464提交次数27,555
 */
public class PivotInteger2485 {
    public static void main(String[] args) {
        PivotInteger2485 main = new PivotInteger2485();
        int i = main.pivotInteger(4);
        System.out.println(i);

    }

    public int pivotInteger(int n) {
        if (n == 1) return 1;
        int temp = n-1;

        while (temp-- > 1) {
          int  first = ((1 + temp ) * (temp )) / 2;
          int  last = ((n+1 + temp + 1) * (n - temp - 1)) / 2;
          if (first==last)return temp+1;

        }
        return -1;
    }
}