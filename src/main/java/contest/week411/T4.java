package contest.week411;

public class T4 {
    public static void main(String[] args) {

    }

    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        long[] answer = new long[queries.length];

        // 预计算前缀和
        int n = s.length();
        int[] prefixZeros = new int[n + 1];
        int[] prefixOnes = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixZeros[i + 1] = prefixZeros[i] + (s.charAt(i) == '0' ? 1 : 0);
            prefixOnes[i + 1] = prefixOnes[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for (int q = 0; q < queries.length; q++) {
            int li = queries[q][0];
            int ri = queries[q][1];
            long count = 0;

            // 使用滑动窗口计算满足条件的子字符串数量
            for (int i = li; i <= ri; i++) {
                for (int j = i; j <= ri; j++) {
                    int zeros = prefixZeros[j + 1] - prefixZeros[i];
                    int ones = prefixOnes[j + 1] - prefixOnes[i];

                    if (zeros <= k && ones <= k) {
                        count++;
                    } else {
                        break; // 由于前缀和的性质，如果当前不满足，后续的也不会满足
                    }
                }
            }

            answer[q] = count;
        }

        return answer;
    }
}
