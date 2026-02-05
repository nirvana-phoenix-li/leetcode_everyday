package test.t202602;

public class T22 {
    public static void main(String[] args) {

        String phone = "15271589254";
        phone = phone.replaceAll("(\\d{3})\\d{4}(\\d*)", "$1****$2");
        System.out.println(phone);
    }
}
