package everyday.y2025.august;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 47,324/62.3K
 * 通过率
 * 75.9%
 */
public class CountSquares1277 {
    public static void main(String[] args) {

        //[[0,1,1,1],[1,1,1,1],[0,1,1,1]]
        CountSquares1277 main = new CountSquares1277();
        int[][] ints = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};

        int i = main.countSquares(ints);
        System.out.println(i);

    }

    public int countSquares(int[][] matrix) {
        int maxSide = Integer.max(matrix.length, matrix[0].length);

        int answer = 0;
        int current = 1;
        while (current < maxSide) {
            for (int i = 0; i <= matrix.length - current; i++) {
                for (int j = 0; j <= matrix[0].length - current; j++) {

                    boolean flag = true;
                    for (int k = i; k < i + current; k++) {
                        if (!flag) {
                            break;
                        }
                        for (int l = j; l < j + current; l++) {
                            if (matrix[k][l] == 0) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
            }
            current++;
        }

        return answer;
    }
}
