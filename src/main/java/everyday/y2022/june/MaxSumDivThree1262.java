package everyday.y2022.june;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * 通过次数26,586提交次数48,885
 */
public class MaxSumDivThree1262 {
    public static void main(String[] args) {
        MaxSumDivThree1262 main = new MaxSumDivThree1262();
        int[] ints = {2, 6, 2, 2, 7};
//        [1,2,3,4,4]
//        [2,6,2,2,7]
        int i = main.maxSumDivThree(ints);
        System.out.println(i);

    }


    public int maxSumDivThree(int[] nums) {

        ArrayList<Integer> greetOne = new ArrayList<>();
        ArrayList<Integer> greetTwo = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num % 3 == 0) {
                count += num;
            } else if (num % 3 == 1) {
                greetOne.add(num);
            }
            if (num % 3 == 2) {
                greetTwo.add(num);
            }
        }
        greetOne.sort(Comparator.comparingInt(a -> a));
        greetTwo.sort(Comparator.comparingInt(a -> a));
//        int oneNum = greetOne.size();
//        int twoNum = greetTwo.size();
//        if (greetOne.size() >= 3) {
//            oneNum = greetOne.size() % 3;
//            for (int i = oneNum ; i < greetOne.size(); i++) {
//                count += greetOne.get(i);
//            }
//        }
//
//        if (greetTwo.size() >= 3) {
//            twoNum = greetTwo.size() % 3;
//            for (int i = twoNum; i < greetTwo.size(); i++) {
//                count += greetTwo.get(i);
//            }
//        }
//
//        if (oneNum == twoNum) {
//            for (int i = 0; i < oneNum; i++) {
//                count += greetOne.get(i);
//                count += greetTwo.get(i);
//            }
//        } else if (oneNum == 2 && twoNum == 1) {
//            count += greetOne.get(1);
//            count += greetTwo.get(0);
//        }else if (oneNum == 1 && twoNum == 2) {
//            count += greetOne.get(0);
//            count += greetTwo.get(1);
//        }

        while (greetOne.size() >= 3 && greetTwo.size() >= 3) {
            int sizeOne = greetOne.size();
            int sizeTwo = greetTwo.size();
            if (greetOne.size() >= 3){

            }

        }

        return count;
    }
}
