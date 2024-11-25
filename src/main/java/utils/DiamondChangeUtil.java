package utils;

public class DiamondChangeUtil {
    public static void main(String[] args) {
        String packetInformWechatUrl = convert("PACKET_INFORM_WECHAT_URL");
        System.out.println(packetInformWechatUrl);
    }

    public static String convert(String input) {
        String lowerCase = input.replaceAll("_", "-").toLowerCase();
        return lowerCase;
    }
}
