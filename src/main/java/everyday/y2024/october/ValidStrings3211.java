package everyday.y2024.october;

import java.util.ArrayList;
import java.util.List;

/**
 * 3211. 生成不含相邻零的二进制字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 如果一个二进制字符串 x 的所有长度为 2 的
 * 子字符串
 * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 * <p>
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： ["010","011","101","110","111"]
 * <p>
 * 解释：
 * <p>
 * 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 1
 * <p>
 * 输出： ["0","1"]
 * <p>
 * 解释：
 * <p>
 * 长度为 1 的有效字符串有："0" 和 "1"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 18
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 8.9K
 * 提交次数
 * 10.3K
 * 通过率
 * 86.2%
 */
public class ValidStrings3211 {

    public static void main(String[] args) {
        List<String> strings = new ValidStrings3211().validStrings(3);
        System.out.println(strings);
    }

    public List<String> validStrings(int n) {
        ArrayList<String> answerList = new ArrayList<>(n);
        int currentLength = 0;
        while (currentLength < n) {
            ArrayList<String> newList = new ArrayList<>();
            if (answerList.size() == 0) {
                newList.add("0");
                newList.add("1");
            } else {
                for (String s : answerList) {
                    if (s.substring(currentLength - 1).equals("1")) {
                        newList.add(s + "0");
                        newList.add(s + "1");
                    } else {
                        newList.add(s + "1");
                    }
                }
            }
            answerList = newList;
            currentLength++;
        }
        return answerList;

    }

}
