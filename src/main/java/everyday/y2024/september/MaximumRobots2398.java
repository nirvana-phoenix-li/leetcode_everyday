package everyday.y2024.september;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MaximumRobots2398 {
    public static void main(String[] args) {
        Date date = new Date();
        date.setTime(date.getTime() + (1000 * 60 * 60 * 24));
        Timestamp timestamp = new Timestamp(1726191146566l);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = timestamp.toLocalDateTime().format(formatter);
        System.out.println("Formatted LocalDateTime: " + formattedDate);


    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        return 0;
    }

}
