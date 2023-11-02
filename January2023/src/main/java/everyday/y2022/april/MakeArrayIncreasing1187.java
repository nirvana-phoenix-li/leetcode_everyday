package everyday.y2022.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1187. 使数组严格递增
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 * <p>
 * <p>
 * 通过次数8,059提交次数14,095
 */
public class MakeArrayIncreasing1187 {
    public static void main(String[] args) {
        int[] ints = {1, 6, 5};
        Integer[] integers = Arrays.stream(ints).boxed().sorted(Comparator.comparingInt(a -> -a)).distinct().toArray(Integer[]::new);

        System.out.println(Arrays.toString(integers));


    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if (arr1.length == 1) {
            return 0;
        }

        List<Integer> standbyList = new ArrayList<>();
        for (int i : arr2) {
            standbyList.add(i);
        }
        standbyList = standbyList.stream().sorted().sorted(Comparator.comparingInt(a -> -a)).distinct().collect(Collectors.toList());
        for (int i = 0; i < arr1.length - 1; i++) {
//if ()
        }


        return 0;
    }
}
