package everyday.y2022.july;

import java.math.BigInteger;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 通过次数289,517提交次数527,744
 */
public class AddStrings415 {
    public static void main(String[] args) {
        AddStrings415 main = new AddStrings415();
//        167141802233061013023557799168121920809282032
//        167141802233061013023557799168121920809282032

//        "401716832807512840963"
//        "167141802233061013023557397451289113296441069"
        String s = main.addStrings("401716832807512840963", "167141802233061013023557397451289113296441069");
        System.out.println(s);

    }

    public String addStrings(String num1, String num2) {
        BigInteger first = transform(num1);
        BigInteger last = transform(num2);
        String sum = first.add(last).toString();



        return String.valueOf(sum);
    }

    private BigInteger transform(String num1) {
        if (num1.length() < 18) {
            return BigInteger.valueOf(Long.parseLong(num1));
        } else {
            BigInteger init = BigInteger.ZERO;
            for (int i = 0; i < num1.length(); i += 18) {
                int edge=i + 18;
                if (i + 18 > num1.length()) {
                    edge=num1.length();
                }
                BigInteger bigInteger = BigInteger.valueOf(Long.parseLong(num1.substring(i, edge)));
                for (int j = 0; j < num1.length() - 18 - i; j++) {
                    bigInteger = bigInteger.multiply(BigInteger.TEN);
                }
                init = init.add(bigInteger);
            }
            return init;
        }
    }
}
