package everyday.june;

public class FinalValueAfterOperations2011 {
    public static void main(String[] args) {

    }

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
