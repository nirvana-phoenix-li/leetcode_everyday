package everyday.y2025.september;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 *
 * 提示：
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 *
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 79,251/232.3K
 * 通过率
 * 34.1%
 */
public class FractionToDecimal166 {
    public static void main(String[] args) {


        String log = "[TID: bc6d5bfe98284e9f8af51ee88ac1d90d.565062.17587845295432135] 进入风控V2.0,方法名:[YHRiskTaskServiceImpl.fetchRiskLevelV2(..)]调用结束,消耗[104ms],返回值:[YhResponse:{\"code\":200000,\"ok\":true,\"result\":{\"riskCode\":10000,\"riskLevel\":0,\"riskMsg\":\"中低风险\"}}] @@@ 参数:[yhRiskTaskRequest:[YHRiskTaskRequest:{\"businessType\":\"7\"";

        Map<String, String> info = parseLogSimple(log);
        System.out.println("解析结果:");
        info.forEach((key, value) -> System.out.println(key + ": " + value));

    }
    public static Map<String, String> parseLogSimple(String log) {
        Map<String, String> result = new HashMap<>();

        if (log == null || log.isEmpty()) {
            return result;
        }

        // 提取TID
        String tid = extractBetween(log, "[TID: ", "]");
        if (tid != null) result.put("tid", tid);

        // 提取消耗时间
        String costTime = extractBetween(log, "消耗[", "ms]");
        if (costTime != null) result.put("costTime", costTime);

        // 提取整个JSON返回值
        String jsonPart = extractBetween(log, "返回值:[", "}]");
        if (jsonPart != null) {
            jsonPart += "}";

            // 从JSON中提取具体字段
            String riskCode = extractBetween(jsonPart, "\"riskCode\":", ",");
            if (riskCode != null) result.put("riskCode", riskCode.trim());

            String riskLevel = extractBetween(jsonPart, "\"riskLevel\":", ",");
            if (riskLevel != null) result.put("riskLevel", riskLevel.trim());

            String riskMsg = extractBetween(jsonPart, "\"riskMsg\":\"", "\"");
            if (riskMsg != null) result.put("riskMsg", riskMsg);
        }

        return result;
    }

    private static String extractBetween(String source, String start, String end) {
        try {
            int startIndex = source.indexOf(start);
            if (startIndex == -1) return null;

            startIndex += start.length();
            int endIndex = source.indexOf(end, startIndex);
            if (endIndex == -1) return null;

            return source.substring(startIndex, endIndex);
        } catch (Exception e) {
            return null;
        }
    }
}
