package everyday.y2024.september;

import java.util.Deque;
import java.util.LinkedList;

public class MaxConsecutiveAnswers2024 {
    public static void main(String[] args) {

        MaxConsecutiveAnswers2024 main = new MaxConsecutiveAnswers2024();
        int i = main.maxConsecutiveAnswers("TTFTTFTT", 1);
        System.out.println(i);

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = Math.max(extracted(answerKey, k, 'T'),
                extracted(answerKey, k, 'F'));
        return max;

    }

    private int extracted(String answerKey, int k, char input) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(-1);
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (input == answerKey.charAt(i)) {
                count++;
            } else {
                if (deque.size() <= k) {
                    deque.addLast(i);
                    count++;
                } else {
                    Integer i2 = deque.pollFirst();
                    Integer i1 = deque.peekFirst();
                    Integer gap = i1 - i2;
                    count -= gap;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
