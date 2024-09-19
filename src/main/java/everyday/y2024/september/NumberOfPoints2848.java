package everyday.y2024.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 2848. 与车相交的点
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 * <p>
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,6],[1,5],[4,7]]
 * 输出：7
 * 解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,3],[5,8]]
 * 输出：7
 * 解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= starti <= endi <= 100
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 19K
 * 提交次数
 * 24.9K
 * 通过率
 * 76.3%
 */
public class NumberOfPoints2848 {
    public static void main(String[] args) {
        NumberOfPoints2848 main = new NumberOfPoints2848();
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(2, 3));
        list.add(Arrays.asList(3, 9));
        list.add(Arrays.asList(5, 7));
        list.add(Arrays.asList(4, 10));
        list.add(Arrays.asList(9, 10));
        System.out.println(main.numberOfPoints(list));

    }

    public int numberOfPoints(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (List<Integer> num : nums) {
            int left = num.get(0), right = num.get(1);

            ArrayList<Integer> willRemove = new ArrayList<>();
            for (Integer integer : treeMap.keySet()) {
                List<Integer> list = treeMap.get(integer);
                //没有任何相交
                if (num.get(1) < list.get(0) || num.get(0) > list.get(1)) {
                }else {
                    left=Math.min(left, list.get(0));
                    right=Math.max(right, list.get(1));
                    willRemove.add(integer);
                }
            }
            for (Integer i : willRemove) {
                treeMap.remove(i);
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right);
            treeMap.put(left, list);
        }

        int sum = 0;
        for (Integer i : treeMap.keySet()) {
            sum+=treeMap.get(i).get(1)-treeMap.get(i).get(0)+1;
        }
        return sum;
    }
}
