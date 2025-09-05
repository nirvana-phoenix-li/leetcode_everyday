package utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class YHMD5Utils {
    public static void main(String[] args) {
        String s = md5("被邀请人是否来自用户");
        System.out.println(s);

    }

    public static String md5(String key) {
        String md5 = null;
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (StringUtils.isEmpty(key)) {
            return "";
        } else {
            byte[] defaultBytes = key.getBytes();

            try {
                MessageDigest algorithm = MessageDigest.getInstance("MD5");
                algorithm.reset();
                algorithm.update(defaultBytes);
                byte[] messageDigest = algorithm.digest();
                char[] str = new char[32];
                int k = 0;

                for(int i = 0; i < 16; ++i) {
                    byte byte0 = messageDigest[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 15];
                    str[k++] = hexDigits[byte0 & 15];
                }

                md5 = new String(str);
            } catch (NoSuchAlgorithmException var10) {
                NoSuchAlgorithmException nsae = var10;
                nsae.printStackTrace();
            }

            return md5;
        }
    }
}
