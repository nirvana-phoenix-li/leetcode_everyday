package everyday.y2022.july;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1499. 满足不等式的最大值
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 * <p>
 * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
 * <p>
 * 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
 * 输出：4
 * 解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 10 + -10 + |5 - 6| = 1 。
 * 没有其他满足条件的点，所以返回 4 和 1 中最大的那个。
 * 示例 2：
 * <p>
 * 输入：points = [[0,0],[3,0],[9,2]], k = 3
 * 输出：3
 * 解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= points.length <= 10^5
 * points[i].length == 2
 * -10^8 <= points[i][0], points[i][1] <= 10^8
 * 0 <= k <= 2 * 10^8
 * 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。
 * 通过次数6,570提交次数14,498
 */
public class FindMaxValueOfEquation1499 {
    public static void main(String[] args) {
        FindMaxValueOfEquation1499 main = new FindMaxValueOfEquation1499();
//[[-17,-6],[-4,0],[-2,-16],[-1,2],[0,11],[6,18]]
//        13
        int[][] ints = {{-17,-6},{-4,0},{-2,-16},{-1,2},{0,11},{6,18}};
        int maxValueOfEquation = main.findMaxValueOfEquation(ints, 13);
        System.out.println(maxValueOfEquation);

//        main

    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        //单调队列
        int ans=Integer.MIN_VALUE;
        Deque<int[]> queue=new ArrayDeque<>();   //单调递减双端队列
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            while(!queue.isEmpty()&&queue.peekFirst()[0]<point[0]-k)queue.pollFirst();
            if(!queue.isEmpty())ans=Math.max(ans,point[0]+point[1]+queue.peek()[1]);
            while(!queue.isEmpty()&&queue.peekLast()[1]<point[1]-point[0])queue.pollLast();
            queue.addLast(new int[]{point[0],point[1]-point[0]});
        }
        return ans;
        // //优先队列
        // int ans=Integer.MIN_VALUE;
        // Queue<Integer> queue=new PriorityQueue<>((a,b)->points[b][1]-points[b][0]-points[a][1]+points[a][0]);
        // for(int i=0;i<points.length;i++){
        //     int[] point=points[i];
        //     while(!queue.isEmpty()&&points[queue.peek()][0]<point[0]-k)queue.poll();
        //     if(!queue.isEmpty()){
        //         int[] pj=points[queue.peek()];
        //         ans=Math.max(ans,point[0]+point[1]+pj[1]-pj[0]);
        //     }
        //     queue.add(i);
        // }
        // return ans;
    }

}
