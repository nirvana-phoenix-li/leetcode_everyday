package everyday.y2025.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 * 2273. 移除字母异位词后的结果数组
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
 * <p>
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
 * <p>
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 * <p>
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abba","baba","bbaa","cd","cd"]
 * 输出：["abba","cd"]
 * 解释：
 * 获取结果数组的方法之一是执行下述步骤：
 * - 由于 words[2] = "bbaa" 和 words[1] = "baba" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","baba","cd","cd"] 。
 * - 由于 words[1] = "baba" 和 words[0] = "abba" 是字母异位词，选择下标 1 并删除 words[1] 。
 * 现在 words = ["abba","cd","cd"] 。
 * - 由于 words[2] = "cd" 和 words[1] = "cd" 是字母异位词，选择下标 2 并删除 words[2] 。
 * 现在 words = ["abba","cd"] 。
 * 无法再执行任何操作，所以 ["abba","cd"] 是最终答案。
 * 示例 2：
 * <p>
 * 输入：words = ["a","b","c","d","e"]
 * 输出：["a","b","c","d","e"]
 * 解释：
 * words 中不存在互为字母异位词的两个相邻字符串，所以无需执行任何操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 17,822/28.3K
 * 通过率
 * 63.1%
 */
public class RemoveAnagrams2273 {

    public static void main(String[] args) {
        RemoveAnagrams2273 main = new RemoveAnagrams2273();
        String[] strings = {"a","b","c","d","e"};
        List<String> strings1 = main.removeAnagrams(strings);
        System.out.println(strings1);

    }

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        if (words.length == 1) {
            return result;
        }
        for (int i = 0; i < words.length - 1; i++) {

            if (!isSameWords(words[i], words[i + 1])) {
                result.add(words[i + 1]);
            }
        }
        return result;
    }

    public boolean isSameWords(String first, String second) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            if (firstMap.containsKey(first.charAt(i))) {
                firstMap.put(first.charAt(i), firstMap.get(first.charAt(i)) + 1);
            } else {
                firstMap.put(first.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < second.length(); i++) {
            if (secondMap.containsKey(second.charAt(i))) {
                secondMap.put(second.charAt(i), secondMap.get(second.charAt(i)) + 1);
            } else {
                secondMap.put(second.charAt(i), 1);
            }
        }
        if (firstMap.size() != secondMap.size()) {
            return false;
        }

        for (Character c : firstMap.keySet()) {
            Integer i = firstMap.get(c);
            Integer j = secondMap.get(c);
            if (!Objects.equals(i, j)) {
                return false;
            }
        }

        return true;
    }
}
