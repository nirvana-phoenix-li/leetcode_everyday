package everyday.y2025.august;


/**
 * 1504. 统计全 1 子矩形
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,0,1],[1,1,0],[1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 150
 * mat[i][j] 仅包含 0 或 1
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 20,541/30.7K
 * 通过率
 * 67.0%
 */
public class NumSubmat1504 {

    public static void main(String[] args) {
        NumSubmat1504 main = new NumSubmat1504();
//        [[1,0,1],[1,1,0],[1,1,0]]
        int[][] ints = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        int i = main.numSubmat(ints);
        System.out.println(i);
    }

    public int numSubmat(int[][] mat) {

        int answer = 0;
        int currentLeft = 1;
        int currentUp = 1;
        while (currentLeft < mat.length) {
            for (int i = 0; i <= mat.length - currentLeft; i++) {


                while (currentUp < mat[0].length) {
                    for (int j = 0; j <= mat[0].length - currentUp; j++) {
                        boolean flag = true;
                        for (int k = i; k < i + currentLeft; k++) {
                            if (!flag) {
                                break;
                            }
                            for (int l = j; l < j + currentUp; l++) {
                                if (mat[k][l] == 0) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            answer++;
                        }
                    }
                    currentUp++;
                }


            }
            currentLeft++;
            currentUp = 1;
        }

        return answer;
    }
}
