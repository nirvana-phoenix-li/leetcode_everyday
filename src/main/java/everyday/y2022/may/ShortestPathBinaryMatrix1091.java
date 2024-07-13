package everyday.y2022.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 * 通过次数70,655提交次数177,844
 */
public class ShortestPathBinaryMatrix1091 {
    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        return 0;

    }

    private List<int[]> findAlive(int row, int col, int[][] grid) {
        int length = grid.length;
        ArrayList<int[]> arrayList = new ArrayList<>();
        if (row < length - 1) {
            if (grid[row + 1][col] == 0) {
                arrayList.add(new int[]{row + 1, col});
            }
        }
        if (col < length - 1) {
            if (grid[row][col + 1] == 0) {
                arrayList.add(new int[]{row, col + 1});
            }
        }
        if (row < length - 1 && col < length - 1) {
            if (grid[row + 1][col + 1] == 0) {
                arrayList.add(new int[]{row + 1, col + 1});
            }
        }
        return arrayList;
    }
}
