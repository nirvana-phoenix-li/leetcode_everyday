package everyday.y2026.january;

/**
 * 1582. 二进制矩阵中的特殊位置
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
 * <p>
 * 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,0,0],[0,0,1],[1,0,0]]
 * 输出：1
 * 解释：位置 (1, 2) 是一个特殊位置，因为 mat[1][2] == 1 且第 1 行和第 2 列的其他所有元素都是 0。
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * 解释：位置 (0, 0)，(1, 1) 和 (2, 2) 都是特殊位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] 是 0 或 1。
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 52,209/74.5K
 * 通过率
 * 70.1%
 */
public class NumSpecial1582 {

    public static void main(String[] args) {
        int[][] ints = {{1, 0, 0},{0,1,0},{0,0,1}};
        int i = new NumSpecial1582().numSpecial(ints);
        System.out.println(i);
    }

    public int numSpecial(int[][] mat) {
        int answer = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (judge(mat, i, j)) {
                        answer++;
                    }
                }
            }
        }
        return answer;

    }

    private boolean judge(int[][] mat, int row, int col) {
        int rowCount = 0, colCount = 0;
        for (int i = 0; i < mat.length; i++) {
            if (colCount > 1) {
                return false;
            }
            if (mat[i][col] == 1) {
                colCount++;
            }
        }
        for (int i = 0; i < mat[row].length; i++) {
            if (rowCount > 1) {
                return false;
            }
            if (mat[row][i] == 1) {
                rowCount++;
            }
        }
        return rowCount == 1 && colCount == 1;
    }
}
