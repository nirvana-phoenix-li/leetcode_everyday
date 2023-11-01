package test;

public class T77 {
    public static void main(String[] args) {
        String input = "1624539264800444751,1624539264799991067,1624539264800768155,1624539264800023423,1624539264800522142,1624539264800776821,1624539264799969597,1624539264800130192,1624539264800767755,1624539264800329889,1624539264800333742,1624539264800014222";
        String[] split = input.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append("\"");
            stringBuilder.append(s);
            stringBuilder.append("\"");
            stringBuilder.append(",");
        }
        System.out.println(stringBuilder.toString());
        System.out.println(split.length);
        System.out.println("2023年04月第1周".substring(0, 8));
    }
}
