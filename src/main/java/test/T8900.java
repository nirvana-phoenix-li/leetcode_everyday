package test;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class T8900 {
    public static void main(String[] args) {
        String s = "[\"IT0001\",\"SW00681\",\"SW00647\",\"SW01301\",\"SW01302\",\"SW01278\",\"SW01205\",\"SW01144\",\"SW01029\",\"SW01011\",\"SW01284\",\"SW01191\",\"SW01192\",\"SW01134\",\"SW01072\",\"SW01107\",\"SW01237\",\"SW01321\",\"SW01275\",\"SW01317\",\"SW01232\",\"SW01180\",\"SW01178\",\"SW01064\",\"SW01093\",\"SW01095\",\"SW00953\",\"SW01266\",\"SW01260\",\"SW01160\",\"SW01304\",\"SW01326\",\"SW01226\",\"SW01130\",\"SW01298\",\"SW01291\",\"SW01195\",\"SW01136\"]";
        String substring = s.substring(1, s.length() - 1);
        JSONArray jsonArray =
                JSONArray.parseArray(s);
        List<String> collect = jsonArray.stream().map(x -> (String) x).collect(Collectors.toList());
        System.out.println(collect);

//
//        System.out.println(jsonArray);
//
//        System.out.println(substring);
    }
}
