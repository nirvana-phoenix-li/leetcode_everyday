package everyday.y2024.august;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 代码
 * <p>
 * <p>
 * 测试用例
 * 测试结果
 * 测试结果
 * 3133. 数组最后一个元素的最小值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
 * <p>
 * 返回 nums[n - 1] 可能的 最小 值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, x = 4
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, x = 7
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * 数组 nums 可以是 [7,15] ，最后一个元素为 15 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, x <= 108
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 11.1K
 * 提交次数
 * 21K
 * 通过率
 * 52.8%
 */
public class MinEnd3133 {
    public static void main(String[] args) {
        MinEnd3133 main = new MinEnd3133();
        long l = main.minEnd(3, 4);
        System.out.println(l);

    }

    public long minEnd2(int n, int x) {
        long original = x;
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        int count = 0;
        while (x > 0) {
            int temp = x % 2;
            if (temp == 0) {
                zeroIndex.add(count);
            }
            x /= 2;
            count++;
        }


        int size = zeroIndex.size();
        if (n <= 1 << size) {
            Deque<Integer> innerIndex = new LinkedList<>();
            int current = 0;
            n--;
            while (n > 0) {
                int temp = n % 2;
                if (temp == 1) {
                    innerIndex.add(current++);
                }
                n /= 2;
            }

            while (innerIndex.size() > 0) {
                Integer pollIndex = innerIndex.poll();
                original += 1 << zeroIndex.get(size - pollIndex - 1);
            }
        } else {
            original = (1 << count) - 1;
            int surplus = n - (1 << size);
            original += surplus * (1 << count);
//            while (surplus-- > 0) {
//                original += 1 << count++;
//            }
        }
        return original;
    }


    public long minEnd(int n, int x) {
        long original = x;
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        int count = 0;
        while (x > 0) {
            int temp = x % 2;
            if (temp == 0) {
                zeroIndex.add(count);
            }
            x /= 2;
            count++;
        }


        int size = zeroIndex.size();

        int prifix = (1 << size);
        n--;
        int first = n % prifix;
        int second = n / prifix;

        Deque<Integer> innerIndex = new LinkedList<>();
        int current = 0;
//        first--;
        while (first > 0) {
            int temp = first % 2;
            if (temp == 1) {
                innerIndex.add(current++);
            }
            first /= 2;
        }

        while (innerIndex.size() > 0) {
            Integer pollIndex = innerIndex.poll();

            original += 1 << (zeroIndex.get(size - pollIndex - 1) - 1);
//            if (pollIndex == 0) {
//                original++;
//            }else {
//                original += 1 << zeroIndex.get(size - pollIndex - 1);
//
//            }
        }

        original += second * (1 << count);
        return original;
    }
}
