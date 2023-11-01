package everyday.march;

/**
 * 1092. 最短公共超序列
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * <p>
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 * 通过次数8,602提交次数14,854
 */
public class ShortestCommonSupersequence1092 {
    public static void main(String[] args) {

    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int count = Integer.MAX_VALUE;
        int size=-1;
        //假设1在前面，2在后面
//        for (int i = 0; i < ; i++) {
//
//        }
        return null;
    }
}
