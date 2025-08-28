package test.yhTest;

import com.yonghui.common.util.MD5Utils;

public class Md5Test {
    public static void main(String[] args) {
        String key = MD5Utils.md5("被邀请人是否来自用户");
        System.out.println(key);
    }
}
