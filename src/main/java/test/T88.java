package test;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.List;

public class T88 {
    public static void main(String[] args) {

        String  config="[13989359318035249761,108979364828092077,876912568652975635,935592772117828860]";
        List<String> longs = JSON.parseArray(config, String.class);
        System.out.println(longs.size());

        long l = 334210518799641963l;
        System.out.println(l);
    }

    private static String calculate(String input) {
        String lowerCase = input.replaceAll("_", "-").toLowerCase();

        return lowerCase;

    }

}
