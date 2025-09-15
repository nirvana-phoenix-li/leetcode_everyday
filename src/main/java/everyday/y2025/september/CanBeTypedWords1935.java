package everyday.y2025.september;

/**
 * 1935. 可以输入的最大单词数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * <p>
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 * 示例 2：
 * <p>
 * 输入：text = "leet code", brokenLetters = "lt"
 * 输出：1
 * 解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
 * 示例 3：
 * <p>
 * 输入：text = "leet code", brokenLetters = "e"
 * 输出：0
 * 解释：无法输入任何单词，因为字母键 'e' 已损坏。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 104
 * 0 <= brokenLetters.length <= 26
 * text 由若干用单个空格分隔的单词组成，且不含任何前导和尾随空格
 * 每个单词仅由小写英文字母组成
 * brokenLetters 由 互不相同 的小写英文字母组成
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 26,865/34.9K
 * 通过率
 * 77.0%
 */
public class CanBeTypedWords1935 {

    public static void main(String[] args) {
        CanBeTypedWords1935 main = new CanBeTypedWords1935();
        int i = main.canBeTypedWords("leet code", "lt");
        System.out.println(i);
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] split = text.split(" ");

        int count = 0;
        for (String word : split) {
            for (int i = 0; i < brokenLetters.length(); i++) {
                if (word.contains(String.valueOf(brokenLetters.charAt(i)))) {
                    count++;
                    break;
                }
            }

        }
        return split.length - count;
    }
}
