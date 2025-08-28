package everyday.y2025.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3446. 按对角线进行矩阵排序
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
 * <p>
 * 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
 * 右上角三角形 的对角线按 非递减顺序 排序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,7,3],[9,8,2],[4,5,6]]
 * <p>
 * 输出： [[8,2,3],[9,6,7],[4,5,1]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序：
 * <p>
 * [1, 8, 6] 变为 [8, 6, 1]。
 * [9, 5] 和 [4] 保持不变。
 * 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序：
 * <p>
 * [7, 2] 变为 [2, 7]。
 * [3] 保持不变。
 * 示例 2：
 * <p>
 * 输入： grid = [[0,1],[1,2]]
 * <p>
 * 输出： [[2,1],[1,0]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[1]]
 * <p>
 * 输出： [[1]]
 * <p>
 * 解释：
 * <p>
 * 只有一个元素的对角线已经符合要求，因此无需修改。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -105 <= grid[i][j] <= 105
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 7,902/9.3K
 * 通过率
 * 85.1%
 */
public class SortMatrix3446 {
    public static void main(String[] args) {
        SortMatrix3446 main = new SortMatrix3446();
//         [[1,7,3],[9,8,2],[4,5,6]]
        int[][] ints = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        int[][] ints1 = main.sortMatrix(ints);
        System.out.println(Arrays.deepToString(ints1));

    }


    public int[][] sortMatrix(int[][] grid) {
        int length = grid.length;
        int[][] targetArr = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            int col = i;
            int row = 0;
            ArrayList<Integer> integers = new ArrayList<>();
            while (col < length) {
                integers.add(grid[col++][row++]);
            }
            List<Integer> collect = integers.stream().sorted(Comparator.comparingInt(a -> -a)).collect(Collectors.toList());
            int colCopy = i;
            int rowCopy = 0;
            for (Integer integer : collect) {
                targetArr[colCopy++][rowCopy++] = integer;
            }
        }

        for (int i = 1; i< length; i++) {
            int col = 0;
            int row = i;
            ArrayList<Integer> integers = new ArrayList<>();
            while (row < length) {
                integers.add(grid[col++][row++]);
            }
            List<Integer> collect = integers.stream().sorted(Comparator.comparing(a -> a)).collect(Collectors.toList());
            int colCopy = 0;
            int rowCopy = i;
            for (Integer integer : collect) {
                targetArr[colCopy++][rowCopy++] = integer;
            }
        }



        return targetArr;
    }
}
