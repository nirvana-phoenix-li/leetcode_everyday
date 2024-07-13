package test;

public class T999 {
    public static void main(String[] args) {
        String hhhh = "QX00054 QX00055 QX00056 QX00057 QX00058 QX00059 QX00060 QX00061 SW01592 SW01593 SW01594 SW01595 SW01596 SW01597 SW01598 SW01599 SW01600 SW01601 SW01602 SW01603 SW01604 SW01605 SW01606 SW01607 SW01608 SW01609 SW01610";
        String replace = hhhh.replace(" ", "\",\"");
        System.out.println(replace);
        int count = count(3);
        System.out.println(count);
    }

    public static int count(Integer input) {
        return input * 2;
    }
}
