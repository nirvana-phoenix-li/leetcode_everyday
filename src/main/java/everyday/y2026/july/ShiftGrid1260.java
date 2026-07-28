package everyday.y2026.july;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * 通过次数
 * 57,220/86.2K
 * 通过率
 * 66.4%
 */
public class ShiftGrid1260 {
    public static void main(String[] args) {
        ShiftGrid1260 main = new ShiftGrid1260();
        int[][] arr = {
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        };
        List<List<Integer>> lists = main.shiftGrid(arr, 4);
        System.out.println(lists);

    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int colLen = grid.length;
        int valLen = grid[0].length;
        int[][] result = new int[colLen][valLen];

        int startIndex = colLen * valLen;
        int fixIndex = startIndex -(k % startIndex);

        for (int i = 0; i < startIndex; i++) {
            fixIndex=fixIndex%startIndex;
            result[i/valLen][i%valLen]=  grid[fixIndex/valLen][fixIndex%valLen];
            fixIndex++;
        }

        List<List<Integer>> outList = new ArrayList<>();
        for (int i = 0; i < colLen; i++) {
            List<Integer> innerList = new ArrayList<>();
            outList.add(innerList);
            for (int j = 0; j < valLen; j++) {
                innerList.add(result[i][j]);
            }
        }
        return outList;
    }
    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int colLen = grid.length;
        int valLen = grid[0].length;
        int[][] result = new int[colLen][valLen];

        int startCol = valLen - ((k - 1) / valLen) - 1;
        int startVal = (colLen - (k % colLen)) % colLen;
        startCol = Math.max(startCol, 0);
        startVal = Math.max(startVal, 0);

        if (k == 0) {
            result = grid;
            List<List<Integer>> outList = new ArrayList<>();
            for (int i = 0; i < colLen; i++) {
                List<Integer> innerList = new ArrayList<>();
                outList.add(innerList);
                for (int j = 0; j < valLen; j++) {
                    innerList.add(result[i][j]);
                }
            }
            return outList;
        }

        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < valLen; j++) {
                result[i][j] = grid[startCol][startVal];
                startVal++;
                if (startVal == valLen) {
                    startVal = 0;

                    startCol++;
                    if (startCol == colLen) {
                        startCol = 0;
                    }
                }
            }
        }


        List<List<Integer>> outList = new ArrayList<>();
        for (int i = 0; i < colLen; i++) {
            List<Integer> innerList = new ArrayList<>();
            outList.add(innerList);
            for (int j = 0; j < valLen; j++) {
                innerList.add(result[i][j]);
            }
        }
        return outList;
    }
}
