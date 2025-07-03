package everyday.y2025;

/**
 * 125. 验证回文串
 * 尝试过
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 738,027/1.5M
 * 通过率
 * 48.3%
 */
public class IsPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new IsPalindrome125().isPalindrome(s);
        System.out.println(palindrome);

    }
    public boolean isPalindrome(String s) {

        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            while (first < last && (s.charAt(first) < 48   ||s.charAt(first) >57&&s.charAt(first) < 65 || (s.charAt(first) > 90 && s.charAt(first) < 97)
                    || s.charAt(first) > 122)) {
                first++;
            }

            while (first < last
                    && (s.charAt(last) < 48   ||s.charAt(last) >57&&s.charAt(last) < 65 || (s.charAt(last) > 90 && s.charAt(last) < 97) || s.charAt(last) > 122)) {
                last--;
            }

            if (s.charAt(first) != s.charAt(last) ) {
                if((s.charAt(first)>=48&&s.charAt(first)<=57)||(s.charAt(last)>=48&&s.charAt(last)<=57)){
                    return false;
                }else{
                    if(  s.charAt(first) + 32 != s.charAt(last) &&
                            s.charAt(first) != s.charAt(last) + 32){
                        return false;
                    }
                }
            }
            first++;
            last--;
        }
        return true;
    }
}
