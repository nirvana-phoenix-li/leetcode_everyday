package everyday.y2022.march;

import java.util.PriorityQueue;

/**
 * 1637. 两点之间不包含任何点的最宽垂直区域
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 * <p>
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * ​
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * 示例 2：
 * <p>
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi <= 109
 */
public class MaxWidthOfVerticalArea1637 {
    public static void main(String[] args) {

        MaxWidthOfVerticalArea1637 main = new MaxWidthOfVerticalArea1637();
        int[][] ints = {{8,7},{9,9},{7,4},{9,7}};
        int i = main.maxWidthOfVerticalArea(ints);
        System.out.println(i);

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int[] point : points) {
            priorityQueue.offer(point[0]);
        }
        int maxGap = 0;
        int help = -1;
        while (priorityQueue.size() != 0) {
            Integer integer = priorityQueue.poll();
            if (help == -1) {
                help = integer;
            } else {
                int gap = integer - help;
                help=integer;
                maxGap = Math.max(gap, maxGap);
            }
        }
        return maxGap;
    }
}
