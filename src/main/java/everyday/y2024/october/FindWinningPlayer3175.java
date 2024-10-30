package everyday.y2024.october;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 3175. 找到连续赢 K 场比赛的第一位玩家
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
 * <p>
 * 给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不相同 。
 * <p>
 * 所有玩家从编号 0 到 n - 1 排成一列。
 * <p>
 * 比赛进行方式如下：
 * <p>
 * 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
 * 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
 * 这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
 * <p>
 * 请你返回这个比赛的赢家编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：skills = [4,2,6,3,9], k = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 一开始，队列里的玩家为 [0,1,2,3,4] 。比赛过程如下：
 * <p>
 * 玩家 0 和 1 进行一场比赛，玩家 0 的技能等级高于玩家 1 ，玩家 0 胜出，队列变为 [0,2,3,4,1] 。
 * 玩家 0 和 2 进行一场比赛，玩家 2 的技能等级高于玩家 0 ，玩家 2 胜出，队列变为 [2,3,4,1,0] 。
 * 玩家 2 和 3 进行一场比赛，玩家 2 的技能等级高于玩家 3 ，玩家 2 胜出，队列变为 [2,4,1,0,3] 。
 * 玩家 2 连续赢了 k = 2 场比赛，所以赢家是玩家 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：skills = [2,5,4], k = 3
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 一开始，队列里的玩家为 [0,1,2] 。比赛过程如下：
 * <p>
 * 玩家 0 和 1 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
 * 玩家 1 和 2 进行一场比赛，玩家 1 的技能等级高于玩家 2 ，玩家 1 胜出，队列变为 [1,0,2] 。
 * 玩家 1 和 0 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
 * 玩家 1 连续赢了 k = 3 场比赛，所以赢家是玩家 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == skills.length
 * 2 <= n <= 105
 * 1 <= k <= 109
 * 1 <= skills[i] <= 106
 * skills 中的整数互不相同。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 16.9K
 * 提交次数
 * 32.4K
 * 通过率
 * 52.0%
 */
public class FindWinningPlayer3175 {
    public static void main(String[] args) {
        FindWinningPlayer3175 main = new FindWinningPlayer3175();
        int[] ints = {2, 5, 4};
        int winningPlayer = main.findWinningPlayer(ints, 3);
        System.out.println(winningPlayer);


    }

    public int findWinningPlayer(int[] skills, int k) {
        class Person {
            int originalIndex;
            int strength;

            public Person(int originalIndex, int strength) {
                this.originalIndex = originalIndex;
                this.strength = strength;
            }
        }

        Deque<Person> deque = new LinkedList<>();

        for (int i = 0; i < skills.length; i++) {
            deque.addLast(new Person(i, skills[i]));
        }

        int count = 1;
        Person currentWinner = deque.removeFirst();
        while (count < k) {
            Person pop = deque.removeFirst();
            if (currentWinner.strength > pop.strength) {
                count++;
                deque.addLast(pop);
            } else {
                count = 1;
                deque.addLast(pop);
                currentWinner = pop;
            }
        }
        return currentWinner.originalIndex;
    }
}
