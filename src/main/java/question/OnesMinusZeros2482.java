package question;


import java.util.Arrays;

/**
 * 2482. 行和列中一和零的差值
 * 给你一个下标从 0 开始的 m x n 二进制矩阵 grid 。
 * <p>
 * 我们按照如下过程，定义一个下标从 0 开始的 m x n 差值矩阵 diff ：
 * <p>
 * 令第 i 行一的数目为 onesRowi 。
 * 令第 j 列一的数目为 onesColj 。
 * 令第 i 行零的数目为 zerosRowi 。
 * 令第 j 列零的数目为 zerosColj 。
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * 请你返回差值矩阵 diff 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,1],[1,0,1],[0,0,1]]
 * 输出：[[0,0,4],[0,0,4],[-2,-2,2]]
 * 解释：
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
 * - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
 * - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1]]
 * 输出：[[5,5,5],[5,5,5]]
 * 解释：
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * grid[i][j] 要么是 0 ，要么是 1 。
 * 通过次数4,942提交次数5,996
 */
public class OnesMinusZeros2482 {
    public static void main(String[] args) {
        OnesMinusZeros2482 main = new OnesMinusZeros2482();
        int[][] ints = {{1, 1, 1}, {1, 1, 1}};
        int[][] ints1 = main.onesMinusZeros(ints);
        System.out.println(Arrays.deepToString(ints1));


    }

    public int[][] onesMinusZeros(int[][] grid) {
        int[][] diff = new int[grid.length][grid[0].length];
        int[] rows = new int[grid[0].length];
        int[] cols = new int[grid.length];


        for (int i = 0; i < grid[0].length; i++) {
            int temp = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    temp++;
                } else {
                    temp--;
                }
            }
            rows[i] = temp;
        }

        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] == 1) {
                    temp++;
                } else {
                    temp--;
                }
            }
            cols[i] = temp;
        }


        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff[i].length; j++) {
                diff[i][j] = rows[i] + cols[j];

            }
        }
        return diff;
    }
}
