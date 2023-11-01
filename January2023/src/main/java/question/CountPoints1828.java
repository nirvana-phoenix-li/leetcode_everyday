package question;

import java.util.Arrays;

/**
 * 1828. 统计一个圆中点的数目
 * 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 * <p>
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 * <p>
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 * <p>
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= x​​​​​​i, y​​​​​​i <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数。
 * 通过次数29,148提交次数32,808
 */
public class CountPoints1828 {
    public static void main(String[] args) {
        CountPoints1828 main = new CountPoints1828();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        int[] ints = main.countPoints(points, queries);
        System.out.println(Arrays.toString(ints));


    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] resInt = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int tempCount = 0;
            for (int j = 0; j < points.length; j++) {
                int[] query = queries[i];
                int[] point = points[j];
                boolean flag = judgeInCircle(point[0], point[1], query[0], query[1], query[2]);
                if (flag) tempCount++;
            }
            resInt[i] = tempCount;
        }
        return resInt;
    }

    private boolean judgeInCircle(int x1, int y1, int x2, int y2, int distance) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= distance * distance;
    }

}
