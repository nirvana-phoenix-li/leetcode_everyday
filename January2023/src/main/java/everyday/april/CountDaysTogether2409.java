package everyday.april;

import java.time.LocalDate;

public class CountDaysTogether2409 {
    public static void main(String[] args) {
        CountDaysTogether2409 main = new CountDaysTogether2409();
        String        arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31";
        int i = main.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(i);

//        arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/count-days-spent-together
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String basePrefix = "2021-";
        LocalDate aliceStart = LocalDate.parse(basePrefix + arriveAlice);
        LocalDate aliceEnd = LocalDate.parse(basePrefix + leaveAlice);

        LocalDate bobStart = LocalDate.parse(basePrefix + arriveBob);
        LocalDate bobEnd = LocalDate.parse(basePrefix + leaveBob);

        if (aliceStart.compareTo(bobEnd) > 0 || aliceEnd.compareTo(bobStart) < 0) {
            return 0;
        }

        LocalDate start = aliceStart.compareTo(bobStart) > 0 ? aliceStart : bobStart;
        LocalDate end = aliceEnd.compareTo(bobEnd) > 0 ? bobEnd : aliceEnd;
        int days = end.getDayOfYear() - start.getDayOfYear() + 1;
        return days;
    }
}
