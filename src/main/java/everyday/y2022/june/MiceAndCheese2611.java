package everyday.y2022.june;


import java.util.Arrays;

/**
 * 2611. 老鼠和奶酪
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * <p>
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * 示例 2：
 * <p>
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == reward1.length == reward2.length <= 105
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 * 通过次数9,995提交次数18,555
 */
public class MiceAndCheese2611 {
    public static void main(String[] args) {
        MiceAndCheese2611 main = new MiceAndCheese2611();
        int[] ints = {1, 1, 3, 4};
        int[] reward2 = {4,4,1,1};
        int i = main.miceAndCheese(ints, reward2, 2);
        System.out.println(i);

    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int length = reward1.length;
        int[] diff = new int[length];
        for (int i = 0; i < length; i++) {
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        int answer = 0;

        for (int i : reward2) {
            answer+=i;
        }

        for (int i = length-1; i >=length-k ; i--) {
            answer+=diff[i];
        }
        return answer;
    }
}
