package everyday.january;

/**
 * 2351. 第一个出现两次的字母
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * <p>
 * 注意：
 * <p>
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * 示例 2：
 * <p>
 * 输入：s = "abcdd"
 * 输出："d"
 * 解释：
 * 只有字母 'd' 出现两次，所以返回 'd' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 由小写英文字母组成
 * s 包含至少一个重复字母
 * 通过次数34,002提交次数39,433
 */
public class RepeatedCharacter2351 {
    public static void main(String[] args) {
        RepeatedCharacter2351 main = new RepeatedCharacter2351();
        char abcdd = main.repeatedCharacter("abcdd");
        System.out.println(abcdd);
    }

    public char repeatedCharacter(String s) {
        int help = 0;
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.charAt(i) - 'a' + 1;
            int temp = help >> i1;
            if ((temp % 2) == 1) {
                return (char) ('a' + i1-1);
            } else {
                help += 1 << i1;
            }
        }
        return ' ';
    }
}
