package everyday.y2024.august;

import java.util.ArrayList;
import java.util.List;

/**
 * 3148. 矩阵中的最大得分
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。
 * <p>
 * 你可以从 任一 单元格开始，并且必须至少移动一次。
 * <p>
 * 返回你能得到的 最大 总得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
 * <p>
 * 输出：9
 * <p>
 * 解释：从单元格 (0, 1) 开始，并执行以下移动：
 * - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。
 * - 从单元格 (2, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。
 * 总得分为 2 + 7 = 9 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[4,3,2],[3,2,1]]
 * <p>
 * 输出：-1
 * <p>
 * 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 12.8K
 * 提交次数
 * 21K
 * 通过率
 * 60.7%
 */
public class MaxScore3148 {
    public int maxScore(List<List<Integer>> grid) {
        int maxValue = Integer.MIN_VALUE;
        //左边最小，右边最大
        ArrayList<List<int[]>> helpList = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                Integer value = grid.get(i).get(j);
                if (i == 0 && j == 0) {
                    ArrayList<int[]> arrayList = new ArrayList<>();
                    arrayList.add(new int[]{value,value});
                    helpList.add(arrayList);
                }else if (i == 0 ) {

                }

            }

        }
        return 0;


    }
}
