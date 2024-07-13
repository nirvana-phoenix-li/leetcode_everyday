package everyday.y2022.february;

import java.util.HashMap;

/**
 * 1234. 替换子串得到平衡字符串
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * <p>
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 * <p>
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 * <p>
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 * 通过次数17,664提交次数42,152
 */
public class BalancedString1234 {
    public static void main(String[] args) {
        BalancedString1234 main = new BalancedString1234();
        int qqqq = main.balancedString("WWEQERQWQWWRWWERQWEQ");
        System.out.println(qqqq);

    }

    public int balancedString(String s) {
        HashMap<Character, Integer> diction = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (diction.containsKey(letter)) {
                diction.put(letter, diction.get(letter) + 1);
            } else {
                diction.put(letter, 1);
            }
        }

        int standard = s.length() / 4;
        int result = 0;
        for (Character character : diction.keySet()) {
            if (diction.get(character) > standard) {
                result = result + diction.get(character) - standard;
            }
        }
        return result;
    }
}
