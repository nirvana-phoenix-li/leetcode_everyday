package everyday.y2022.june;


import java.util.Arrays;

/**
 * 2559. 统计范围内的元音字符串数
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 * <p>
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 * <p>
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 * <p>
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 105
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 105
 * 1 <= queries.length <= 105
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 * 通过次数10,662提交次数17,469
 */
public class VowelStrings2559 {
    public static void main(String[] args) {
        VowelStrings2559 main = new VowelStrings2559();
        String[] strings = {"aba", "bcb", "ece", "aa", "e"};
        int[][] ints = {{0, 2}, {1, 4}, {1, 1}};
        int[] vowelStrings = main.vowelStrings(strings, ints);
        System.out.println(Arrays.toString(vowelStrings));

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] sumPri = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            boolean vowelString = isVowelString(words[i]);
            if (vowelString) {
                if (i == 0) {
                    sumPri[i] = 1;
                }else {
                    sumPri[i] = sumPri[i - 1] + 1;
                }
            }else {
                if (i == 0) {
                    sumPri[i] = 0;
                }else {
                    sumPri[i] = sumPri[i - 1];
                }
            }
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            if (queries[j][0]-1<0){
                result[j] = sumPri[queries[j][1]];
            }else {
                result[j] = sumPri[queries[j][1]]-sumPri[queries[j][0]-1];
            }
        }
        return result;
    }

    private boolean isVowelString(String input) {
        boolean end = input.endsWith("a") || input.endsWith("e") || input.endsWith("i") || input.endsWith("o") || input.endsWith("u");
        boolean start = input.startsWith("a") || input.startsWith("e") || input.startsWith("i") || input.startsWith("o") || input.startsWith("u");
        return end && start;
    }
}
