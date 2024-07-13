package everyday.y2022.may;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
 *
 * 子字符串 是字符串中连续的字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "0110", n = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "0110", n = 4
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 不是 '0' 就是 '1'
 * 1 <= n <= 109
 * 通过次数13,114提交次数21,155
 */
public class QueryString1016 {
    public static void main(String[] args) {

        QueryString1016 main = new QueryString1016();
        boolean b = main.queryString("10010111100001110010", 10);
        System.out.println(b);
//
//        "10010111100001110010"
//        10
    }

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String s1 = number2BinaryString(i);
            if (!s.contains(s1)) return false;
        }
        return true;
    }

    private String number2BinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            int i = n % 2;
            n /= 2;
            sb.insert(0, i);
        }
        return sb.toString();
    }
}
