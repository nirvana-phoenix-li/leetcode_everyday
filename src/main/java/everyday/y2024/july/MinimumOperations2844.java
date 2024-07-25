package everyday.y2024.july;

/**
 * 2844. 生成特殊数字的最少操作
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 * <p>
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 * <p>
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 * <p>
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "2245047"
 * 输出：2
 * 解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
 * 示例 2：
 * <p>
 * 输入：num = "2908305"
 * 输出：3
 * 解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
 * 示例 3：
 * <p>
 * 输入：num = "10"
 * 输出：1
 * 解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= num.length <= 100
 * num 仅由数字 '0' 到 '9' 组成
 * num 不含任何前导零
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 9.3K
 * 提交次数
 * 19.5K
 * 通过率
 * 47.7%
 */
public class MinimumOperations2844 {
    public static void main(String[] args) {
        MinimumOperations2844 main = new MinimumOperations2844();
        int i = main.minimumOperations("10");
        System.out.println(i);

    }

    private int extracted1(int rightIndex, char[] charArray, int length) {
        int temp = rightIndex - 1;
        while (temp >= 0) {
            if (charArray[temp] == '2' || charArray[temp] == '7') {
                return length - temp - 2;
            }
            temp--;
        }
        return length;
    }

    private int extracted(int rightIndex, char[] charArray, int length) {
        int temp = rightIndex - 1;
        while (temp >= 0) {
            if (charArray[temp] == '0' || charArray[temp] == '5') {
                return length - temp - 2;
            }
            temp--;
        }
        return length - 1;
    }

    public int minimumOperations(String num) {
        if (num.equals("0")) return 0;
        if (num.length()==1)return 1;
        char[] charArray = num.toCharArray();
        int length = charArray.length;
        int rightIndex = length - 1;
        int firstValue = Integer.MAX_VALUE;
        int lastValue = Integer.MAX_VALUE;
        while (rightIndex >= 0) {
            if (charArray[rightIndex] == '0') {
                if (firstValue == Integer.MAX_VALUE) {
                    firstValue = extracted(rightIndex, charArray, length);
                }
            }
            if (charArray[rightIndex] == '5') {
                if (lastValue == Integer.MAX_VALUE) {
                    lastValue = extracted1(rightIndex, charArray, length);
                }
            }
            rightIndex--;
        }
        if (firstValue == Integer.MAX_VALUE&&lastValue == Integer.MAX_VALUE) {
            return length;
        }
        return Math.min(firstValue, lastValue);

    }
}
