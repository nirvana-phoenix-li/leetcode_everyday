package everyday.y2024.september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 2306. 公司命名
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
 * <p>
 * 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
 * 交换 ideaA 和 ideaB 的首字母。
 * 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
 * 否则，不是一个有效的名字。
 * 返回 不同 且有效的公司名字的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ideas = ["coffee","donuts","time","toffee"]
 * 输出：6
 * 解释：下面列出一些有效的选择方案：
 * - ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
 * - ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
 * - ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
 * - ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
 * - ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
 * - ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
 * 因此，总共有 6 个不同的公司名字。
 * <p>
 * 下面列出一些无效的选择方案：
 * - ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
 * - ("time", "toffee")：在原数组中存在交换后形成的两个名字。
 * - ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
 * 示例 2：
 * <p>
 * 输入：ideas = ["lack","back"]
 * 输出：0
 * 解释：不存在有效的选择方案。因此，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= ideas.length <= 5 * 104
 * 1 <= ideas[i].length <= 10
 * ideas[i] 由小写英文字母组成
 * ideas 中的所有字符串 互不相同
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 6.9K
 * 提交次数
 * 14.2K
 * 通过率
 * 48.7%
 */
public class DistinctNames2306 {
    public static void main(String[] args) {
        DistinctNames2306 main = new DistinctNames2306();
        String[] strings = {"coffee", "donuts", "time", "toffee"};
        long l = main.distinctNames(strings);
        System.out.println(l);

    }

    public long distinctNames(String[] ideas) {

        HashMap<String, Set<String>> suffixMap = new HashMap<>();

        for (int i = 0; i < ideas.length; i++) {
            String before = String.valueOf(ideas[i].charAt(0));
            String later = ideas[i].substring(1);
            if (suffixMap.containsKey(before)) {
                suffixMap.get(before).add(later);
            } else {
                Set<String> list = new HashSet<>();
                list.add(later);
                suffixMap.put(before, list);
            }
        }

        long count = 0;


        for (String s : suffixMap.keySet()) {
            Set<String> beforeSet = suffixMap.get(s);
            for (String s1 : suffixMap.keySet()) {
                if (!s1.equals(s)) {
                    Set<String> afterSet = suffixMap.get(s1);

                    int common = 0;
                    for (String temp : afterSet) {
                        if (beforeSet.contains(temp)) {
                            common++;
                        }
                    }

                    count += (long) (beforeSet.size() - common) * (afterSet.size() - common);
                }

            }
        }
        return count;
    }



    public long distinctNames2(String[] ideas) {

        HashMap<String, Set<String>> suffixMap = new HashMap<>();

        for (int i = 0; i < ideas.length; i++) {
            String before = String.valueOf(ideas[i].charAt(0));
            String later = ideas[i].substring(1);
            if (suffixMap.containsKey(later)) {
                suffixMap.get(later).add(before);
            } else {
                Set<String> list = new HashSet<>();
                list.add(before);
                suffixMap.put(later, list);
            }
        }

        long count = 0;


        for (String s : suffixMap.keySet()) {
            Set<String> beforeSet = suffixMap.get(s);
            for (String s1 : suffixMap.keySet()) {
                if (!s1.equals(s)) {
                    Set<String> afterSet = suffixMap.get(s1);

                    int common = 0;
                    for (String temp : afterSet) {
                        if (beforeSet.contains(temp)) {
                            common++;
                        }
                    }

                    count += (long) (beforeSet.size() - common) * (afterSet.size() - common);
                }

            }
        }
        return count;
    }

}
