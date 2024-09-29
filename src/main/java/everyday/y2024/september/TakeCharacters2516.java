package everyday.y2024.september;

/**
 * 2516. 每种字符至少取 K 个
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * <p>
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabaaaacaabc", k = 2
 * 输出：8
 * 解释：
 * 从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
 * 从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
 * 共需要 3 + 5 = 8 分钟。
 * 可以证明需要的最少分钟数是 8 。
 * 示例 2：
 * <p>
 * 输入：s = "a", k = 1
 * 输出：-1
 * 解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由字母 'a'、'b'、'c' 组成
 * 0 <= k <= s.length
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 17.8K
 * 提交次数
 * 38.1K
 * 通过率
 * 46.7%
 */
public class TakeCharacters2516 {
    public static void main(String[] args) {

        TakeCharacters2516 main = new TakeCharacters2516();
        int i = main.takeCharacters("aabaaaacaabc", 2);
        System.out.println(i);

    }

    public int takeCharacters(String s, int k) {


        int aNum = 0, bNum = 0, cNum = 0;
        int left = 0, right = s.length() - 1;

        while (aNum < k || bNum < k|| cNum < k) {
            if (right < left) {
                return -1;
            }

            while (aNum < k) {
                int tempRight = right;
                int tempLeft = left;
                while (tempRight > tempLeft) {
                    tempRight--;
                    tempLeft++;
                    if (s.charAt(tempLeft) == 'a') {
                        left = tempLeft;
                        aNum++;
                        break;
                    }
                    if (s.charAt(tempRight) == 'a') {
                        right = tempRight;
                        aNum++;
                        break;
                    }
                }
            }
            while (bNum < k) {
                int tempRight = right;
                int tempLeft = left;
                while (tempRight > tempLeft) {
                    tempRight--;
                    tempLeft++;
                    if (s.charAt(tempLeft) == 'b') {
                        left = tempLeft;
                        bNum++;
                        break;
                    }
                    if (s.charAt(tempRight) == 'b') {
                        right = tempRight;
                        bNum++;
                        break;
                    }
                }
            }
            while (cNum < k) {
                int tempRight = right;
                int tempLeft = left;
                while (tempRight > tempLeft) {
                    tempRight--;
                    tempLeft++;
                    if (s.charAt(tempLeft) == 'c') {
                        left = tempLeft;
                        cNum++;
                        break;
                    }
                    if (s.charAt(tempRight) == 'c') {
                        right = tempRight;
                        cNum++;
                        break;
                    }
                }
            }


        }
        return s.length()-right +left;


    }
}
