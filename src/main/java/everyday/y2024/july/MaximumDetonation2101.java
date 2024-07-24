package everyday.y2024.july;

import java.util.*;

/**
 * 2101. 引爆最多的炸弹
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[2,1,3],[6,1,4]]
 * 输出：2
 * 解释：
 * 上图展示了 2 个炸弹的位置和爆炸范围。
 * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
 * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
 * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,1,5],[10,10,5]]
 * 输出：1
 * 解释：
 * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * 输出：5
 * 解释：
 * 最佳引爆炸弹为炸弹 0 ，因为：
 * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
 * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
 * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
 * 所以总共有 5 个炸弹被引爆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 17.7K
 * 提交次数
 * 36.3K
 * 通过率
 * 48.8%
 */
public class MaximumDetonation2101 {

    public static void main(String[] args) {
        MaximumDetonation2101 main = new MaximumDetonation2101();

//        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        int[][] bombs = {{1,1,100000}, {100000,100000,1}};
        int i = main.maximumDetonation(bombs);
        System.out.println(i);

    }

    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            for (int j = i + 1; j < bombs.length; j++) {

                long sqzSize = countSqzSize(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                //第一个可以炸到第二个
                if ( (long) bombs[i][2] * (long) bombs[i][2] >= sqzSize) {
                    if (hashMap.containsKey(i)) {
                        hashMap.get(i).add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        hashMap.put(i, list);
                    }
                }

                //第二个可以炸到第一个
                if ((long) bombs[j][2] * (long) bombs[j][2] >= sqzSize) {
                    if (hashMap.containsKey(j)) {
                        hashMap.get(j).add(i);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        hashMap.put(j, list);
                    }
                }
            }
        }

        HashMap<Integer, Set<Integer>> flowMap = new HashMap<>();
        for (Integer i : hashMap.keySet()) {
            List<Integer> directNodes = hashMap.get(i);


            HashSet<Integer> originSet = new HashSet<>();
            originSet.add(i);

            for (Integer directNode : directNodes) {
                if (flowMap.containsKey(directNode)) {
                    originSet.addAll(flowMap.get(directNode));
                }
            }

            Deque<Integer> deque = new LinkedList<>(directNodes);
            while (!deque.isEmpty()) {
                Integer node = deque.poll();
                if (!originSet.contains(node)) {
                    originSet.add(node);
                    List<Integer> integers = hashMap.get(node);
                    if (integers != null) {
                        deque.addAll(integers);
                    }
                }
            }
            originSet.addAll(directNodes);
            flowMap.put(i, originSet);
        }

        int maxCount = 0;
        for (Integer i : flowMap.keySet()) {
            int size = flowMap.get(i).size();
            maxCount = Math.max(maxCount, size);
        }
        return maxCount == 0 ? 1 : maxCount;
    }

    private long countSqzSize(int rowX, int colX, int rowY, int colY) {
        return (long) (rowX - rowY) * (rowX - rowY) + (long) (colX - colY) * (colX - colY);
    }
}
