package everyday.y2026.june;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3014. 输入单词需要的最少按键次数 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word，由 不同 小写英文字母组成。
 * <p>
 * 电话键盘上的按键与 不同 小写英文字母集合相映射，可以通过按压按键来组成单词。例如，按键 2 对应 ["a","b","c"]，我们需要按一次键来输入 "a"，按两次键来输入 "b"，按三次键来输入 "c"。
 * <p>
 * 现在允许你将编号为 2 到 9 的按键重新映射到 不同 字母集合。每个按键可以映射到 任意数量 的字母，但每个字母 必须 恰好 映射到 一个 按键上。你需要找到输入字符串 word 所需的 最少 按键次数。
 * <p>
 * 返回重新映射按键后输入 word 所需的 最少 按键次数。
 * <p>
 * 下面给出了一种电话键盘上字母到按键的映射作为示例。注意 1，*，# 和 0 不 对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word = "abcde"
 * 输出：5
 * 解释：图片中给出的重新映射方案的输入成本最小。
 * "a" -> 在按键 2 上按一次
 * "b" -> 在按键 3 上按一次
 * "c" -> 在按键 4 上按一次
 * "d" -> 在按键 5 上按一次
 * "e" -> 在按键 6 上按一次
 * 总成本为 1 + 1 + 1 + 1 + 1 = 5 。
 * 可以证明不存在其他成本更低的映射方案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：word = "xycdefghij"
 * 输出：12
 * 解释：图片中给出的重新映射方案的输入成本最小。
 * "x" -> 在按键 2 上按一次
 * "y" -> 在按键 2 上按两次
 * "c" -> 在按键 3 上按一次
 * "d" -> 在按键 3 上按两次
 * "e" -> 在按键 4 上按一次
 * "f" -> 在按键 5 上按一次
 * "g" -> 在按键 6 上按一次
 * "h" -> 在按键 7 上按一次
 * "i" -> 在按键 8 上按一次
 * "j" -> 在按键 9 上按一次
 * 总成本为 1 + 2 + 1 + 2 + 1 + 1 + 1 + 1 + 1 + 1 = 12 。
 * 可以证明不存在其他成本更低的映射方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 26
 * word 仅由小写英文字母组成。
 * word 中的所有字母互不相同。
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 13,081/19.8K
 * 通过率
 * 66.1%
 */
public class MinimumPushes3014 {
    public static void main(String[] args) {
        MinimumPushes3014 main = new MinimumPushes3014();
        int i = main.minimumPushes("xycdefghij");
        System.out.println(i);


    }

    public int minimumPushes(String word) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            hashMap.put(word.charAt(i), hashMap.getOrDefault(word.charAt(i), 1));
        }
        int answer = 0;
        List<Integer> collect = hashMap.values().stream().sorted().collect(Collectors.toList());
        for (int i = collect.size() - 1; i >= 0; i--) {
            int i1 = ((collect.size() - i - 1) / 8) + 1;
            int i2 = collect.get(i) * (i1);
            answer += i2;
        }
        return answer;
    }
}
