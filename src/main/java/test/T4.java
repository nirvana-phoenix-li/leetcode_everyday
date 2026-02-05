package test;

import org.apache.commons.lang3.StringUtils;

import javax.com.yonghui.common.exception.common.BadParameterException;
import java.text.ParseException;
import java.time.LocalDate;

public class T4 {
    public static void main(String[] args) throws ParseException {

        T4 main = new T4();


        String text = "13313003333,13400000016,13400000018,13400000055,13767126666,13767126888,13767129999,15090710784,15271589255,15318358724,15588199087,15601882671,15900950359,17600000030,17701896815,18112341234,18250128212,18250128252,18250128312,18641096222,18675597401,18815920827,18930061430,18965175004";
        String[] split = text.split(",");
        for (String item : split) {
            String encrypt = main.caesarAndXOREncrypt(item);
            String decrypt = main.caesarAndXORDecrypt(encrypt);
            if (!item.equals(decrypt)) {
                System.out.println(item + "重大问题！！！！！！");
            } else {
                System.out.println("okkkkkkkkk");
            }
        }


        String s = main.caesarAndXOREncrypt("25271589254");
        System.out.println(s);
        String original = main.caesarAndXORDecrypt(s);
        System.out.println(original);


        String caesared = main.caesarAndXORDecrypt("389352997135");
        System.out.println(caesared);
    }

    /**
     * 凯撒加密和异或，实现对称、简单、难以破解的加密方式
     * 魔数为 15271589254-（年月日数字相加2026-02-04）eg：15271589254-2026-2-4=15271587222
     * 魔数足够长保证每一个数字都能混淆
     *
     * @param mobile
     * @return
     */
    private String caesarAndXOREncrypt(String mobile) {
        try {
            if (StringUtils.isBlank(mobile)) {
                throw new BadParameterException("手机号为空，请检查");
            }
            LocalDate today = LocalDate.now();

            int caesarKey = today.getDayOfWeek().getValue();
            long magicNumber = 15271589254L - today.getYear() - today.getMonthValue() - today.getDayOfMonth();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mobile.length(); i++) {
                int intNumber = mobile.charAt(i) - 48;
                //如果第一个数字是0，那么后面转为long的时候会丢失长度，直接在数字前面补上dummyhead
                if (i == 0 ) {
                    sb.append(caesarKey);
                }

                int caesar = (intNumber + 10 - caesarKey) % 10;
                sb.append(caesar);
            }
            long l = Long.parseLong(sb.toString()) ^ magicNumber;
            return String.valueOf(l);
        } catch (Exception e) {
            return null;
        }
    }

    public String caesarAndXORDecrypt(String encryptedStr) {
        try {
            if (StringUtils.isBlank(encryptedStr)) {
                throw new BadParameterException("加密字符串为空，请检查");
            }
            LocalDate today = LocalDate.now();

            int caesarKey = today.getDayOfWeek().getValue();
            long magicNumber = 15271589254L - today.getYear() - today.getMonthValue() - today.getDayOfMonth();
            long encryptedLong = Long.parseLong(encryptedStr);

            long xorResult = encryptedLong ^ magicNumber;
            String caesarStr = String.valueOf(xorResult);

            //如果第一个数字是0，那么后面转为long的时候会丢失长度，这种情况将caesarKey+1

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < caesarStr.length(); i++) {
                //抛弃第一个dummyhead
                if (i == 0 ) {
                    continue;
                }

                int caesarDigit = caesarStr.charAt(i) - 48;
                int originalDigit = (caesarDigit + caesarKey) % 10;
                sb.append(originalDigit);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}