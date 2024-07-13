package everyday.y2022.july;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 * <p>
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= commands.length <= 104
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 104
 * -3 * 104 <= xi, yi <= 3 * 104
 * 答案保证小于 231
 * 通过次数30,749提交次数68,742
 */
public class RobotSim874 {
    public static void main(String[] args) {
        RobotSim874 main = new RobotSim874();

        int[] commands = {-2,8,3,7,-1};
        int[][] obstacles = new int[][]{{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        int i = main.robotSim(commands, obstacles);
        System.out.println(i);

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int currentX = 0, currentY = 0;
        int direction = 1000000;
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction--;
            } else if (commands[i] == -1) {
                direction++;
            } else {
                int[] nearest = new int[0];
                int surplus = direction % 4;
                if (surplus == 0) {
                    //north
                    nearest = findNearest(obstacles, currentX, currentY, currentX, currentY + commands[i]);
                } else if (surplus == 1) {
                    //west
                    nearest = findNearest(obstacles, currentX, currentY, currentX + commands[i], currentY);
                } else if (surplus == 2) {
                    //south
                    nearest = findNearest(obstacles, currentX, currentY, currentX, currentY - commands[i]);
                } else if (surplus == 3) {
                    //east
                    nearest = findNearest(obstacles, currentX, currentY, currentX - commands[i], currentY);
                }
                currentX = nearest[0];
                currentY = nearest[1];
            }
            max= Math.max(max,currentX * currentX + currentY * currentY);
        }
        return max;
    }

    private int[] findNearest(int[][] obstacles, int currentX, int currentY, int destinationX, int destinationY) {
        int[] ints = new int[2];
        if (currentX == destinationX) {
            int minAbs = Integer.MAX_VALUE;
            ints[0] = currentX;
            for (int i = 0; i < obstacles.length; i++) {
                boolean flag = (obstacles[i][1] > currentY && obstacles[i][1] < destinationY) || (obstacles[i][1] > destinationY && obstacles[i][1] < currentY );
                if (obstacles[i][0] == currentX&&flag) {
                    if (Math.abs(obstacles[i][1] - currentY) < minAbs) {
                        minAbs = obstacles[i][1];
                        if (obstacles[i][1] - currentY > 0) {
                            ints[1] = obstacles[i][1] - 1;
                        } else {
                            ints[1] = obstacles[i][1] + 1;
                        }
                    }
                }
            }
            if (minAbs == Integer.MAX_VALUE) {
                ints[1] = destinationY;
            }
        } else if (currentY == destinationY) {
            int minAbs = Integer.MAX_VALUE;
            ints[1] = currentY;
            for (int i = 0; i < obstacles.length; i++) {
                boolean flag = (obstacles[i][0] > currentX && obstacles[i][0] < destinationX) || (obstacles[i][0] > destinationX && obstacles[i][0] < currentX);
                if (obstacles[i][1] == currentY&&flag) {
                    if (Math.abs(obstacles[i][0] - currentX) < minAbs) {
                        minAbs = obstacles[i][0];
                        if (obstacles[i][0] - currentX > 0) {
                            ints[0] = obstacles[i][0] - 1;
                        } else {
                            ints[0] = obstacles[i][0] + 1;
                        }
                    }
                }
            }
            if (minAbs == Integer.MAX_VALUE) {
                ints[0] = destinationX;
            }
        }
        return ints;
    }
}
