package everyday.y2024.september;

/**
 * 2414. 最长的字母序连续子字符串的长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * <p>
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacaba"
 * 输出：2
 * 解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
 * "ab" 是最长的字母序连续子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abcde"
 * 输出：5
 * 解释："abcde" 是最长的字母序连续子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 21.3K
 * 提交次数
 * 32.3K
 * 通过率
 * 65.8%
 */
public class LongestContinuousSubstring2414 {
    public static void main(String[] args) {
        LongestContinuousSubstring2414 main = new LongestContinuousSubstring2414();
        int i = main.longestContinuousSubstring("pcfftiovoygwwncfgews");
        System.out.println(i);

    }

    public int longestContinuousSubstring(String s) {
        int maxCount = 0;
        char before = ' ';
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (before == ' ') {
                before = s.charAt(i);
                temp = 1;
            } else {
                if (s.charAt(i) - before == 1) {
                    before=s.charAt(i);
                    temp++;
                }else {
                    maxCount=Math.max(maxCount, temp);
                    before = s.charAt(i);
                    temp = 1;
                }
            }
        }
        maxCount=Math.max(maxCount, temp);
        return maxCount;
    }
}
