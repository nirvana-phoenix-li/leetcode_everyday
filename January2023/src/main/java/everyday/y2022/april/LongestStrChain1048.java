package everyday.y2022.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1048. 最长字符串链
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * 示例 2:
 * <p>
 * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * 输出：5
 * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * 示例 3:
 * <p>
 * 输入：words = ["abcd","dbqca"]
 * 输出：1
 * 解释：字链["abcd"]是最长的字链之一。
 * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 * 通过次数26,421提交次数49,374
 */
public class LongestStrChain1048 {
    public static void main(String[] args) {
        LongestStrChain1048 main = new LongestStrChain1048();
//        ["abcd","dbqca"]
//        ["a","b","ab","bac"]
//        ["qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"]
        String[] strings = {"a","b","ab","bac"};
        int i = main.longestStrChain(strings);
        System.out.println(i);


    }

    public int longestStrChain(String[] words) {
        int countMax = Integer.MIN_VALUE;

        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            if (hashMap.containsKey(length)) {
                hashMap.get(length).add(word);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(word);
                hashMap.put(length, strings);
            }
        }
        List<Integer> collect = hashMap.keySet().stream().sorted().collect(Collectors.toList());
        HashMap<String, Integer> diction = new HashMap<>();
        HashMap<String, Integer> innerDiction = new HashMap<>();
        int before = -1;
        for (Integer integer : collect) {
            List<String> list = hashMap.get(integer);
            if (before == -1) {
                before = integer;
                for (String s : list) {
                    innerDiction.put(s, 1);
                }
            } else {
                if (integer - before != 1) {
                    for (String s : list) {
                        innerDiction.put(s, 1);
                    }
                } else {
                    for (String s : list) {
                        int tempCount = 1;
                        for (String head : diction.keySet()) {
                            boolean judge = judge(head, s);
                            if (judge) {
                                if (diction.get(head) + 1 > tempCount) {
                                    tempCount = diction.get(head) + 1;
                                }
                            }
                        }
                        innerDiction.put(s, tempCount);
                    }
                }
                before++;
            }
            diction = (HashMap<String, Integer>) innerDiction.clone();
            for (Integer value : diction.values()) {
                if (value > countMax) countMax = value;
            }
            innerDiction.clear();
        }
        return countMax;
    }

    private boolean judge(String before, String after) {
        boolean life = true;
        for (int i = 0; i < before.length(); i++) {
            if (life) {
                if (before.charAt(i) != after.charAt(i)) {
                    life = false;
                }
            } else {
                if (before.charAt(i) != after.charAt(i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}

