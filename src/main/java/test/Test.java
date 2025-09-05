package test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        boolean messageGray = isMessageGray("async-risk-center-rule-action", "331538001672284528");
        System.out.println(messageGray);
    }

    private static final int SCORE_MOD = 100;

    /**
     * 通过唯一识别key判断某个消息是否应该走新集群灰度逻辑
     *
     * @param topicName
     * @param key
     * @return
     */
    public static boolean isMessageGray(String topicName, String key) {
        if (StringUtils.isAnyBlank(topicName, key)) {
            return false;
        }
        Map<String, Integer> collect = new HashMap<>();
        collect.put("async-risk-center-rule-action", 100);
        Integer grayRatio = collect.get(topicName);
        if (grayRatio == null) {
            return false;
        }
        int score = getScore(key);
        System.out.println(score);
        return score < grayRatio;
    }

    /**
     * 获取分数
     *
     * @param key
     * @return
     */
    public static int getScore(String key) {
        if (null == key) {
            return 0;
        }

        return Math.abs(key.hashCode()) % SCORE_MOD;
    }
}
