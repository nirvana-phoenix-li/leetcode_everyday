package everyday.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 * 通过次数14,101提交次数29,457
 */

public class PrevPermOpt11053 {
    public static void main(String[] args) {
        PrevPermOpt11053 main = new PrevPermOpt11053();
        int[] ints = {3, 1, 1, 3};
        int[] ints1 = main.prevPermOpt1(ints);
        System.out.println(Arrays.toString(ints1));
    }

    public int[] prevPermOpt1(int[] arr) {
        if (arr.length <= 1) return arr;

        ArrayList<Integer> firstList = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();

        int helpIndex = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                helpIndex = i - 1;
                break;
            }
        }

        for (int i = 0; i < helpIndex; i++) {
            firstList.add(arr[i]);
        }
        if (helpIndex == -1) {
            return arr;
        }
        int replace = arr[helpIndex];
        for (int i = helpIndex + 1; i < arr.length; i++) {
            lastList.add(arr[i]);
        }
        int[] ints = searchMax(lastList, replace);
        int max = ints[0];
        lastList.add(replace);
        lastList = lastList.stream().sorted(Comparator.comparingInt(a -> a)).collect(Collectors.toList());
        int[] resultArray = new int[arr.length];

        int helpCount = 0;
        for (Integer integer : firstList) {
            resultArray[helpCount++] = integer;
        }
        resultArray[helpCount++] = max;
        for (Integer integer : lastList) {
            resultArray[helpCount++] = integer;
        }

        return resultArray;
    }

    private int[] searchMax(List<Integer> input, Integer judge) {
        int help = Integer.MIN_VALUE;
        int helpIndex = -1;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(judge)) {
                continue;
            }
            if (input.get(i) > help) {
                help = input.get(i);
                helpIndex = i;
            }
        }
//        input.remove(helpIndex);
        return new int[]{help, helpIndex};
    }

}
