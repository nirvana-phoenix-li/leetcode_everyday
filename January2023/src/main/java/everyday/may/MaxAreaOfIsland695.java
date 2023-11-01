package everyday.may;

import java.util.ArrayList;

/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 * 通过次数280,284提交次数412,018
 */
public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        MaxAreaOfIsland695 main = new MaxAreaOfIsland695();
        int[][] ints = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = main.maxAreaOfIsland(ints);
        System.out.println(i);


    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int andRemove = findAndRemove(i, j, grid);
                    max = Math.max(andRemove, max);
                }
            }
        }
        return max;
    }

    public int findAndRemove(int indexRow, int column, int[][] grid) {
        int count = 0;
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{indexRow, column});
        while (arrayList.size() != 0) {
            ArrayList<int[]> innerList = new ArrayList<>();
            for (int[] ints : arrayList) {
                int innerRow = ints[0];
                int innerCol = ints[1];
                if (grid[innerRow][innerCol] == 1) {
                    count++;
                    grid[innerRow][innerCol] = 0;
                    if (innerRow - 1 >= 0) {
                        innerList.add(new int[]{innerRow - 1, innerCol});
                    }
                    if (innerCol - 1 >= 0) {
                        innerList.add(new int[]{innerRow, innerCol - 1});
                    }
                    if (innerRow + 1 <= grid.length - 1) {
                        innerList.add(new int[]{innerRow + 1, innerCol});
                    }
                    if (innerCol + 1 <=   grid[0].length - 1) {
                        innerList.add(new int[]{innerRow, innerCol + 1});
                    }
                } else {

                }
            }
            arrayList = innerList;
        }
        return count;
    }
}
