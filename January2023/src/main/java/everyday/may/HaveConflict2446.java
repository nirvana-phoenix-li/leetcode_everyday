package everyday.may;

/**
 * 2446. 判断两个事件是否存在冲突
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * <p>
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * 示例 2：
 * <p>
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * 示例 3：
 * <p>
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照 HH:MM 格式给出
 * 通过次数20,906提交次数32,977
 */
public class HaveConflict2446 {
    public static void main(String[] args) {
        HaveConflict2446 main = new HaveConflict2446();
        String[] before = {"01:15","02:00"};
        String[] after = {"02:00","03:00"};
        boolean b = main.haveConflict(before, after);
        System.out.println(b);

    }

    private boolean isGreaterOrEqual(String before, String after) {
        if (Integer.parseInt(before.substring(0, 2)) - Integer.parseInt(after.substring(0, 2)) > 0) {
            return true;
        } else if (Integer.parseInt(before.substring(0, 2)) - Integer.parseInt(after.substring(0, 2)) == 0) {
            if (Integer.parseInt(before.substring(3, 5)) - Integer.parseInt(after.substring(3, 5)) > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        if (isGreaterOrEqual(event1[0], event2[1]) || isGreaterOrEqual(event2[0], event1[1])) {
            return false;
        }
        return true;
    }
}
