package everyday.y2025.august;

import java.util.List;

/**
 * 2781. 最长合法子字符串的长度
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 word 和一个字符串数组 forbidden 。
 * <p>
 * 如果一个字符串不包含 forbidden 中的任何字符串，我们称这个字符串是 合法 的。
 * <p>
 * 请你返回字符串 word 的一个 最长合法子字符串 的长度。
 * <p>
 * 子字符串 指的是一个字符串中一段连续的字符，它可以为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "cbaaaabc", forbidden = ["aaa","cb"]
 * 输出：4
 * 解释：总共有 11 个合法子字符串："c", "b", "a", "ba", "aa", "bc", "baa", "aab", "ab", "abc" 和 "aabc"。最长合法子字符串的长度为 4 。
 * 其他子字符串都要么包含 "aaa" ，要么包含 "cb" 。
 * 示例 2：
 * <p>
 * 输入：word = "leetcode", forbidden = ["de","le","e"]
 * 输出：4
 * 解释：总共有 11 个合法子字符串："l" ，"t" ，"c" ，"o" ，"d" ，"tc" ，"co" ，"od" ，"tco" ，"cod" 和 "tcod" 。最长合法子字符串的长度为 4 。
 * 所有其他子字符串都至少包含 "de" ，"le" 和 "e" 之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 105
 * word 只包含小写英文字母。
 * 1 <= forbidden.length <= 105
 * 1 <= forbidden[i].length <= 10
 * forbidden[i] 只包含小写英文字母。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 6,589/15.6K
 * 通过率
 * 42.4%
 */
public class LongestValidSubstring2781 {
    public static void main(String[] args) {

    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        return 0;
    }
}
