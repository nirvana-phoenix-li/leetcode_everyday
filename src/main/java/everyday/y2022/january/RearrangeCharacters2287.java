package everyday.y2022.january;

import java.util.HashMap;

/**
 * 2287. 重排字符形成目标字符串
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * <p>
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ilovecodingonleetcode", target = "code"
 * 输出：2
 * 解释：
 * 对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
 * 对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
 * 形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
 * 可以形成最多 2 个 "code" 的副本，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abcba", target = "abc"
 * 输出：1
 * 解释：
 * 选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
 * 可以形成最多 1 个 "abc" 的副本，所以返回 1 。
 * 注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
 * 示例 3：
 * <p>
 * 输入：s = "abbaccaddaeea", target = "aaaaa"
 * 输出：1
 * 解释：
 * 选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
 * 可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 1 <= target.length <= 10
 * s 和 target 由小写英文字母组成
 * 通过次数24,232提交次数37,262
 */
public class RearrangeCharacters2287 {
    public static void main(String[] args) {
        RearrangeCharacters2287 main = new RearrangeCharacters2287();
        int i = main.rearrangeCharacters("abbaccaddaeea",
                "aaaaa");
        System.out.println(i);

    }

    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> diction = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (diction.containsKey(key)) {
                diction.put(key, diction.get(key) + 1);
            } else {
                diction.put(key, 1);
            }
        }
        int count = Integer.MAX_VALUE;

        HashMap<Character, Integer> findMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char key = target.charAt(i);
            if (findMap.containsKey(key)) {
                findMap.put(key, findMap.get(key) + 1);
            } else {
                findMap.put(key, 1);
            } 
        }


        for (Character character : findMap.keySet()) {
            if (diction.containsKey(character)) {
                Integer multiple = findMap.get(character);
                count = Math.min(count, diction.get(character)/multiple);
            } else {
                return 0;
            }
        }
        return count;

    }
}
