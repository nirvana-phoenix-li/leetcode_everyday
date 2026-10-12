package everyday.y2026.september;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class DistinctSubseqII940 {
    public static void main(String[] args) {

        ArrayList<String> objects = new ArrayList<>();
        String string1 = "疑似刷单代理";
        String string2 = "寄件";
        String string3 = "派件";
        objects.add(string1);
        objects.add(string2);
        objects.add(string3);
        objects.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println( objects);


        long eventTime = 1790077837072l;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(eventTime), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    public int distinctSubseqII(String s) {
return 0;
    }
}
