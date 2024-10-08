package everyday.y2024.september;


/**
 * 2073. 买票需要的时间
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 * <p>
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 * <p>
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 * <p>
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tickets = [2,3,2], k = 2
 * 输出：6
 * 解释：
 * <p>
 * 队伍一开始为 [2,3,2]，第 k 个人以下划线标识。
 * 在最前面的人买完票后，队伍在第 1 秒变成 [3,2,1]。
 * 继续这个过程，队伍在第 2 秒变为[2,1,2]。
 * 继续这个过程，队伍在第 3 秒变为[1,2,1]。
 * 继续这个过程，队伍在第 4 秒变为[2,1]。
 * 继续这个过程，队伍在第 5 秒变为[1,1]。
 * 继续这个过程，队伍在第 6 秒变为[1]。第 k 个人完成买票，所以返回 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：tickets = [5,1,1,1], k = 0
 * 输出：8
 * 解释：
 * 队伍一开始为 [5,1,1,1]，第 k 个人以下划线标识。
 * 在最前面的人买完票后，队伍在第 1 秒变成 [1,1,1,4]。
 * 继续这个过程 3 秒，队伍在第 4 秒变为[4]。
 * 继续这个过程 4 秒，队伍在第 8 秒变为[]。第 k 个人完成买票，所以返回 8。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == tickets.length
 * 1 <= n <= 100
 * 1 <= tickets[i] <= 100
 * 0 <= k < n
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 20.4K
 * 提交次数
 * 31.7K
 * 通过率
 * 64.5%
 */
public class TimeRequiredToBuy2073 {
    public static void main(String[] args) {
        TimeRequiredToBuy2073 main = new TimeRequiredToBuy2073();
        int[] ints = {2,3,2};
        int i = main.timeRequiredToBuy(ints, 2);
        System.out.println(i);


    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;
        int ticket = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            int param;
            if (i <= k) {
                param = ticket;
            } else {
                param = ticket - 1;
            }
            int temp = tickets[i] - param >= 0 ? param : tickets[i];

            answer += temp;
        }
        return answer;

    }
}
