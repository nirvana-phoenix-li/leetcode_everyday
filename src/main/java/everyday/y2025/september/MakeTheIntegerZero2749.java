package everyday.y2025.september;


/**
 * 2749. 得到整数零需要执行的最少操作数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数：num1 和 num2 。
 * <p>
 * 在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
 * <p>
 * 请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
 * <p>
 * 如果无法使 num1 等于 0 ，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = 3, num2 = -2
 * 输出：3
 * 解释：可以执行下述步骤使 3 等于 0 ：
 * - 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
 * - 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
 * - 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
 * 可以证明 3 是需要执行的最少操作数。
 * 示例 2：
 * <p>
 * 输入：num1 = 5, num2 = 7
 * 输出：-1
 * 解释：可以证明，执行操作无法使 5 等于 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1 <= 109
 * -109 <= num2 <= 109
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 6,921/16.6K
 * 通过率
 * 41.7%
 */
public class MakeTheIntegerZero2749 {
    public static void main(String[] args) {

    }

    //fast power!!!!!!!!!!!!
    public int makeTheIntegerZero(int num1, int num2) {
        int answer = 0;
        if (num2 >= num1) {
            return -1;
        }
        return answer;
    }
}
