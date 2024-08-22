package everyday.y2024.august;

/**
 * 552. 学生出勤记录 II
 * 困难
 * 相关标签
 * 相关企业
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 37.9K
 * 提交次数
 * 62.3K
 * 通过率
 * 60.9%
 */
public class CheckRecord552 {
    public static void main(String[] args) {
//        int i = new CheckRecord552().checkRecord(10101);
//        System.out.println(i);
    }
//
//    public int checkRecord(int n) {
//        if (n == 1) return 3;
//        if (n == 2) return 8;
//        String hasAOneP = "2";
//        String hasATwoP = "0";
//        long hasANoP = 2;
//        long noAOneP = 2;
//        long noATwoP = 1;
//        long noANoP = 1;
//
//        int remember = 2;
//        while (remember < n) {
//            long temphasAOneP = hasANoP;
//            long temphasATwoP = hasAOneP;
//            long temphasANoP = hasAOneP + hasATwoP + hasANoP + noAOneP + noATwoP + noANoP;
//
//            long tempnoAOneP = noANoP;
//            long tempnoATwoP = noAOneP;
//            long tempnoANoP = noAOneP + noATwoP + noANoP;
//
//
//            hasAOneP = temphasAOneP;
//            hasATwoP = temphasATwoP;
//            hasANoP = temphasANoP;
//            noAOneP = tempnoAOneP;
//            noATwoP = tempnoATwoP;
//            noANoP = tempnoANoP;
//
//            remember++;
//        }
//        long l = hasAOneP + hasATwoP + hasANoP + noAOneP + noATwoP + noANoP;
//        return (int) l % (1000000000 + 7);
//    }

    private String calculate(String input, String next) {
        int length1 = input.length();
        int length2 = next.length();
        int maxLength = Math.max(length1, length2);
        int temp = 0;

        boolean isAdd = false;
        StringBuilder sb = new StringBuilder();
        while (temp < maxLength) {
            int index1 = length2 - temp - 1;
            int first = 0;
            if (index1 >= 0) {
                first = next.charAt(index1) - 48;
            }
            int index2 = length1 - temp - 1;
            int second = 0;
            if (index2 >= 0) {
                second = input.charAt(index2) - 48;
            }
            int answer = first + second;
            if (isAdd) {
                answer++;
            }
            if (answer > 9) {
                isAdd = true;
            } else {
                isAdd = false;
            }

            sb.insert(0, answer % 10);
            temp++;
        }

        if (isAdd){
            sb.insert(0, 1);
        }
        return sb.toString();

    }


}
