package everyday.y2024.september;

/**
 * 3174. 清除数字
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。
 * <p>
 * 你的任务是重复以下操作删除 所有 数字字符：
 * <p>
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cb34"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
 * <p>
 * 然后对 s[1] 执行操作，s 变为 "" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母和数字字符。
 * 输入保证所有数字都可以按以上操作被删除。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 8.6K
 * 提交次数
 * 10.7K
 * 通过率
 * 80.0%
 */
public class ClearDigits3174 {
    public static void main(String[] args) {
        ClearDigits3174 main = new ClearDigits3174();
        String s = main.clearDigits("cb34");
        System.out.println(s);

    }

    public String clearDigits(String s) {
        int power=0;
        StringBuilder sb = new StringBuilder();

        for (int z = s.length() - 1; z >= 0; z--) {
            if (s.charAt(z) >= 48 && s.charAt(z) <= 57) {
                power++;
            }else {
                if (power>0){
                    power--;
                }else {
                    sb.insert(0, s.charAt(z));
                }
            }
        }
        return sb.toString();

    }
}
