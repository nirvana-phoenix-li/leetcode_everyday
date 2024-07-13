package everyday.y2023.november;

/**
 * 318. 最大单词长度乘积
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 示例 2：
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * 通过次数
 * 82.8K
 * 提交次数
 * 114.2K
 * 通过率
 * 72.5%
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 */
public class MaxProduct318 {
    public static void main(String[] args) {
        MaxProduct318 main = new MaxProduct318();
        String[] strings = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int i = main.maxProduct(strings);
        System.out.println(i);
    }

    public int maxProduct(String[] words) {
        if (words.length <= 1) return 0;
        int answer = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {

                boolean contain = isContain(words[i], words[j]);
                if (contain) {
                    answer = Integer.max(answer, words[i].length() * words[j].length());
                }
            }
        }
        return answer;
    }

    private boolean isContain(String first, String second) {
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < first.length(); i++) {
            booleans[first.charAt(i) - 97] = true;
        }
        for (int i = 0; i < second.length(); i++) {
            if (booleans[second.charAt(i) - 97]) return false;
        }
        return true;
    }
}
