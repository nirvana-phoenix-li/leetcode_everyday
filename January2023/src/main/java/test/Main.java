package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String a = "13412142351251321321531321321";
        String b = "13412142351251321321531321321";
        String answer = main.addHuge(a, b);
        System.out.println(answer);
    }

    //尽量从
    public String addHuge(String first, String last) {
        int len1 = first.length();
        int len2 = last.length();
        int maxLen = Math.max(len1, len2);
        int times = 1;
        List<String> list = new ArrayList<String>();
        //处理进位1的问题
        boolean isPlus = false;

        while (len1 - 8 * times >= 0 && len2 - 8 * times > 0) {
            String str1, str2;
            if (len1 - 8 * times < 0) {
                str1 = "";
            } else {
                str1 = first.substring(len1 - 8 * times, len1 - 8 * (times - 1));
            }

            if (len1 - 8 * times < 0) {
                str2 = "";
            } else {
                str2 = last.substring(len2 - 8 * times, len1 - 8 * (times - 1));
            }


            Integer temp = Integer.parseInt(str1) + Integer.parseInt(str2);
            if (isPlus) {
                temp++;
            }
            String help = String.valueOf(temp);
            if (help.length() > 8) {
                isPlus = true;
            } else {
                isPlus = false;
            }
            list.add(String.valueOf(temp));

        }

        String answer = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i);
        }
        return answer;
    }
}