package everyday.y2025.august;


import java.util.Arrays;

/**
 * 498. 对角线遍历
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 148,445/260.9K
 * 通过率
 * 56.9%
 */
public class FindDiagonalOrder498 {
    public static void main(String[] args) {
//        [[1,2,3],[4,5,6],[7,8,9]]
        int[][] ints = {{1, 2}, {3, 4}};
        int[] diagonalOrder = new FindDiagonalOrder498().findDiagonalOrder(ints);

        System.out.println(Arrays.toString(diagonalOrder));
    }


    public int[] findDiagonalOrder(int[][] mat) {
        int col = mat.length;
        int row = mat[0].length;
        int total = col * row;
        int[] answer = new int[total];

        int answerIndex = 0;
        boolean flag = true;//true is up and right
        int tempCol = 0;
        int tempRow = 0;
        while (answerIndex< total) {
            while (tempCol >= 0 && tempRow < row &&answerIndex< total) {
                answer[answerIndex++] = mat[tempCol][tempRow];
                if (tempCol == 0) {
                    if (tempRow == row - 1) {
                        tempCol++;
                        break;
                    }
                    tempRow++;
                    break;
                }
                if (tempRow == row - 1) {
                    tempCol--;
                    break;
                }
                tempCol--;
                tempRow++;
            }
            flag = false;
            while (tempCol < col && tempRow >= 0 &&answerIndex< total) {
                answer[answerIndex++] = mat[tempCol][tempRow];
                if (tempRow == 0) {
                    tempCol++;
                    break;
                }
                if (tempCol == col - 1) {
                    tempRow++;
                    break;
                }
                tempCol++;
                tempRow--;
            }
            flag = true;
        }
        return answer;
    }
}
