package everyday.y2024.october;

/**
 * 3216. 交换后字典序最小的字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
 * 字典序最小的字符串
 * 。
 * <p>
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "45320"
 * <p>
 * 输出： "43520"
 * <p>
 * 解释：
 * <p>
 * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "001"
 * <p>
 * 输出： "001"
 * <p>
 * 解释：
 * <p>
 * 无需进行交换，因为 s 已经是字典序最小的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由数字组成。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 10.6K
 * 提交次数
 * 15.5K
 * 通过率
 * 68.2%
 */
public class GetSmallestString3216 {
    public static void main(String[] args) {
        GetSmallestString3216 main = new GetSmallestString3216();
        String smallestString = main.getSmallestString("10");
        System.out.println(smallestString);

    }

    public String getSmallestString(String s) {
        int willChangeIndex = -1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) -s.charAt(i+1)>0&&(s.charAt(i) -s.charAt(i+1))%2==0) {
                willChangeIndex = i;
                break;
            }
        }
        if (willChangeIndex == -1)return s;
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i!=willChangeIndex) {
                    sb.append(s.charAt(i));
                }else {
                    char before = s.charAt(i);
                    i++;
                    char after = s.charAt(i);
                    sb.append(after);
                    sb.append(before);
                }
            }
            return sb.toString();
        }
    }
}
