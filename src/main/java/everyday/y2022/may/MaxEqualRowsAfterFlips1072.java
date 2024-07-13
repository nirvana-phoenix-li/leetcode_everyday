package everyday.y2022.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1072. 按列翻转得到最大值等行数
 * 给定 m x n 矩阵 matrix 。
 * <p>
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * <p>
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 * 通过次数16,488提交次数23,528
 */
public class MaxEqualRowsAfterFlips1072 {
    public static void main(String[] args) {
        MaxEqualRowsAfterFlips1072 main = new MaxEqualRowsAfterFlips1072();
        int[][] ints = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int i = main.maxEqualRowsAfterFlips(ints);

        System.out.println(i);

    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            Boolean flag = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    flag = matrix[i][j] == 0;
                }
                if (flag) {
                    if (matrix[i][j] == 0) {
                        sb.append("1");
                    } else if (matrix[i][j] == 1) {
                        sb.append("0");
                    }
                } else {
                    if (matrix[i][j] == 0) {
                        sb.append("0");
                    } else if (matrix[i][j] == 1) {
                        sb.append("1");
                    }
                }
            }
            String help = sb.toString();
            if (hashMap.containsKey(help)) {
                hashMap.get(help).add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(help, arrayList);
            }
        }
        int count = 0;
        for (List<Integer> value : hashMap.values()) {
            if (value.size() > count) count = value.size();
        }
        return count;
    }
}
