package everyday.y2022.june;


import java.util.HashMap;

/**
 * 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 * 通过次数19,004提交次数25,717
 */
public class EqualPairs2352 {
    public static void main(String[] args) {
        EqualPairs2352 main = new EqualPairs2352();
        int[][] ints = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        int i = main.equalPairs(ints);
        System.out.println(i);


    }


    public int equalPairs(int[][] grid) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                sb.append(ints[i]);
                if (i!= grid.length - 1) {
                    sb.append(",");
                }
            }

            String regex = sb.toString();
            if (hashMap.containsKey(regex)) {
                hashMap.put(regex, hashMap.get(regex) + 1);
            } else {
                hashMap.put(regex, 1);
            }
        }
        for (int i = 0; i < grid.length; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]);
                if (j != grid.length - 1) {
                    sb.append(",");
                }
            }
            String index = sb.toString();
            if (hashMap.containsKey(index)) {
                answer += hashMap.get(index);
            }
        }
        return answer;
    }


}
