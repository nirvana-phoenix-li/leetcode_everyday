package everyday.y2024.july;


import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3111. 覆盖所有点的最少矩形数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有 点。
 * <p>
 * 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必须 满足 x2 - x1 <= w 。
 * <p>
 * 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
 * <p>
 * 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
 * <p>
 * 注意：一个点可以被多个矩形覆盖。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]], w = 1
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (1, 0) ，右上角在 (2, 8) 。
 * 一个矩形的左下角在 (3, 0) ，右上角在 (4, 8) 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], w = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (0, 0) ，右上角在 (2, 2) 。
 * 一个矩形的左下角在 (3, 0) ，右上角在 (5, 5) 。
 * 一个矩形的左下角在 (6, 0) ，右上角在 (6, 6) 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[2,3],[1,2]], w = 0
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 上图展示了一种可行的矩形放置方案：
 * <p>
 * 一个矩形的左下角在 (1, 0) ，右上角在 (1, 2) 。
 * 一个矩形的左下角在 (2, 0) ，右上角在 (2, 3) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * 0 <= xi == points[i][0] <= 109
 * 0 <= yi == points[i][1] <= 109
 * 0 <= w <= 109
 * 所有点坐标 (xi, yi) 互不相同。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 7.4K
 * 提交次数
 * 10K
 * 通过率
 * 74.1%
 */
public class MinRectanglesToCoverPoints3111 {
    public static void main(String[] args) {

    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int[] point : points) {
            hashSet.add(point[0]);
        }

        List<Integer> collect = hashSet.stream().sorted().collect(Collectors.toList());
        if (w == 0) return collect.size();
        int answer = 0;
        int currentSurPlus = w;
        for (int i = 1; i < collect.size(); i++) {
            int gap = collect.get(i) - collect.get(i - 1);
            if (gap > currentSurPlus) {
                currentSurPlus = w;
                answer++;
            } else {
                currentSurPlus -= gap;
            }
        }
        return answer;

    }
}
