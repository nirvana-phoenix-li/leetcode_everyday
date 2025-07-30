package test;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;

public class T77 {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        String s = "[1D, 1H]";
        extracted(s, hashSet);

        System.out.println(hashSet);

        List<String> strings = JSON.parseArray(String.valueOf("[\"实号\", \"\"]"), String.class);
        System.out.println(strings);

        String[] split = StringUtils.split(",");
        System.out.println(split);

    }

    private static void extracted(String s, HashSet<String> hashSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                continue;
            } else if (s.charAt(i) == ','|| s.charAt(i) == ']') {
                hashSet.add(sb.toString());
                sb = new StringBuilder();
                i++;
            }else {
                sb.append(s.charAt(i));
            }
        }
    }
}
