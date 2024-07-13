package everyday.y2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2788. 按分隔符拆分字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * <p>
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * <p>
 * 注意
 * <p>
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["one.two.three","four.five","six"], separator = "."
 * 输出：["one","two","three","four","five","six"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "one.two.three" 拆分为 "one", "two", "three"
 * "four.five" 拆分为 "four", "five"
 * "six" 拆分为 "six"
 * <p>
 * 因此，结果数组为 ["one","two","three","four","five","six"] 。
 * 示例 2：
 * <p>
 * 输入：words = ["$easy$","$problem$"], separator = "$"
 * 输出：["easy","problem"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "$easy$" 拆分为 "easy"（不包括空字符串）
 * "$problem$" 拆分为 "problem"（不包括空字符串）
 * <p>
 * 因此，结果数组为 ["easy","problem"] 。
 * 示例 3：
 * <p>
 * 输入：words = ["|||"], separator = "|"
 * 输出：[]
 * 解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
 * separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 * 社招
 * 校招
 * 实习
 * 未遇到
 * 通过次数
 * 15.4K
 * 提交次数
 * 19.7K
 * 通过率
 * 78.3%
 */
public class SplitWordsBySeparator2788 {
    public static void main(String[] args) {
        SplitWordsBySeparator2788 main = new SplitWordsBySeparator2788();
        ArrayList<String> inputString = new ArrayList<>();
        inputString.add("$easy$");
        inputString.add("$problem$");
        List<String> outputString = main.splitWordsBySeparator(inputString, '$');
        System.out.println(outputString);


    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (String word : words) {
            String[] split = word.split(String.valueOf(separator));
            arrayList.addAll(Arrays.asList(split));
        }
        return arrayList;

    }
}
