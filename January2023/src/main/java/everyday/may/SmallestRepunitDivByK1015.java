package everyday.may;

import java.util.HashSet;

/**
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 *
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 *
 * 注意： n 不符合 64 位带符号整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 *
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 *
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 *
 *
 * 提示：
 *
 * 1 <= k <= 105
 * 通过次数13,804提交次数31,558
 */
public class SmallestRepunitDivByK1015 {
    public static void main(String[] args) {
        SmallestRepunitDivByK1015 main = new SmallestRepunitDivByK1015();
        int i = main.smallestRepunitDivByK(2);
        System.out.println(i);

    }

    public int smallestRepunitDivByK(int k) {
        int help = 1;
        int count = 1;
        HashSet<Integer> hashSet = new HashSet<>();
        while (help % k != 0) {
            int surplus = help % k;
            if (hashSet.contains(surplus)) return -1;
            hashSet.add(surplus);
            help = surplus * 10 + 1;
            count++;
        }
        return count;
    }
}
