package contest.week342;

public class T2 {

    public static void main(String[] args) {
        T2 main = new T2();

    }

    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
