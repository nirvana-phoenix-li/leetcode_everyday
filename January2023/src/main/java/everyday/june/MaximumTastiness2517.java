package everyday.june;

import java.util.Arrays;

/**
 * 2517. 礼盒的最大甜蜜度
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * <p>
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * <p>
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * 示例 2：
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * 示例 3：
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= price.length <= 105
 * 1 <= price[i] <= 109
 * 2 <= k <= price.length
 * 通过次数8,718提交次数11,841
 */
public class MaximumTastiness2517 {

    int k;
    int n;
    int[] ps;

    public static void main(String[] args) {
        MaximumTastiness2517 main = new MaximumTastiness2517();
        int[] ints = {13, 5, 1, 8, 21, 2};
        int i = main.maximumTastiness(ints, 3);
        System.out.println(i);

    }

    public boolean check(int x) {
        if (x == 0) {
            return true;
        }
        int cnt = 1;
        int cur = ps[0] + x;
        for (int p : ps) {
            if (p >= cur) {
                cnt++;
                cur = p + x;
            }
        }
        return cnt >= k;
    }

    public int maximumTastiness(int[] _ps, int _k) {
        ps = _ps;
        Arrays.sort(ps);
        n = ps.length;
        k = _k;
        int l = 0, r = (ps[n - 1] - ps[0]) / (k - 1);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

//    public int maximumTastiness(int[] price, int k) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i : price) {
//            hashSet.add(i);
//        }
//        List<Integer> collect = hashSet.stream().sorted(Comparator.comparingInt(a -> a)).collect(Collectors.toList());
//        if (collect.size() < k) {
//            return 0;
//        } else {
//            int[] ints = new int[k - 1];
//            for (int i = 0; i < k; i++) {
//                ints[i] = price[i + 1] - price[i];
//            }
//            for (int i = k; i < collect.size(); i++) {
//                int gap = price[i] - price[i - 1];
//                for (int j = 0; j < ints.length; j++) {
//
//                }
//
//            }
//        }
//        return 0;
//    }

}
