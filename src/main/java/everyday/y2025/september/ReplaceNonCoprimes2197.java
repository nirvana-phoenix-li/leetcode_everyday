package everyday.y2025.september;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2197. 替换数组中的非互质数
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。请你对数组执行下述操作：
 * <p>
 * 从 nums 中找出 任意 两个 相邻 的 非互质 数。
 * 如果不存在这样的数，终止 这一过程。
 * 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
 * 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
 * <p>
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 * <p>
 * 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [6,4,3,2,7,6,2]
 * 输出：[12,7,6]
 * 解释：
 * - (6, 4) 是一组非互质数，且 LCM(6, 4) = 12 。得到 nums = [12,3,2,7,6,2] 。
 * - (12, 3) 是一组非互质数，且 LCM(12, 3) = 12 。得到 nums = [12,2,7,6,2] 。
 * - (12, 2) 是一组非互质数，且 LCM(12, 2) = 12 。得到 nums = [12,7,6,2] 。
 * - (6, 2) 是一组非互质数，且 LCM(6, 2) = 6 。得到 nums = [12,7,6] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [12,7,6] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 * 示例 2 ：
 * <p>
 * 输入：nums = [2,2,1,1,3,3,3]
 * 输出：[2,1,1,3]
 * 解释：
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3,3] 。
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3] 。
 * - (2, 2) 是一组非互质数，且 LCM(2, 2) = 2 。得到 nums = [2,1,1,3] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [2,1,1,3] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 14,718/32.8K
 * 通过率
 * 44.8%
 */
public class ReplaceNonCoprimes2197 {

    public static void main(String[] args) {
        //[6,4,3,2,7,6,2]
        ReplaceNonCoprimes2197 main = new ReplaceNonCoprimes2197();
//        [517,11,121,517,3,51,3,1887,5]
//        [31,97561,97561,97561,97561,97561,97561,97561,97561]
//        [31,97561,97561,97561,97561,97561,97561,97561,97561]
        int[] ints = {31,97561,97561,97561,97561,97561,97561,97561,97561};
        List<Integer> integers = main.replaceNonCoprimes(ints);

        System.out.println(integers);

    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        if (nums.length == 1){
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(nums[0]);
            return integers;
        }
        LinkedList<Integer> helpList = new LinkedList<>();

        int temp = -1;
        for (int i = 1; i <= nums.length; i++) {
            int second = temp == -1 ? nums[i - 1] : temp;
            Integer maxGCD ;

            if (i==nums.length){
                maxGCD=1;
            }else {
                maxGCD= getMaxGCD(nums[i], second);
            }
            if (maxGCD == 1) {
                if (temp == -1) {
                    helpList.addLast(second);
                } else {
                    //退栈
                    while (!helpList.isEmpty()) {
                        Integer i1 = helpList.pollLast();
                        Integer gcd = getMaxGCD(i1, temp);
                        if (gcd.equals(1)) {
                            helpList.addLast(i1);
                            break;
                        } else {
                            temp = temp * i1 / gcd;
                        }
                    }
                    helpList.addLast(temp);
                    temp = -1;
                }
            } else {
                temp = nums[i] * second / maxGCD;
            }
        }


        return helpList;

    }

    private Integer getMaxGCD(Integer first, Integer second) {
        if (first == second) {
            return first;
        }
        int gcd = -1;
        int min = Math.min(first, second);
        int max = Math.max(first, second);

        while (gcd != 1 &&  max != min) {
            //problem!!!!!!


            gcd = max - min;
            max = Math.max(min, gcd);
            min = Math.min(min, gcd);
        }
        return gcd;
    }

}
