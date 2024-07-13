package contest.week342;

public class T1 {
    public static void main(String[] args) {
        T1 main = new T1();
        String[] strings = {"hey", "aeo", "mu", "ooo", "artro"};


    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int res = 0;
        if (arrivalTime + delayedTime >= 24) {
            res = arrivalTime + delayedTime - 24;
        } else {
            res = arrivalTime + delayedTime;
        }
        return res;
    }
}
