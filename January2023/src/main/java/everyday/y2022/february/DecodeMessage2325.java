package everyday.y2022.february;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2325. 解密消息
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * 输出："the five boxing wizards jump quickly"
 * 解释：对照表如上图所示。
 * 提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 * 通过次数23,332提交次数27,031
 */
public class DecodeMessage2325 {
    public static void main(String[] args) {
        DecodeMessage2325 main = new DecodeMessage2325();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String s = main.decodeMessage(key, message);
        System.out.println(s);

    }

    public String decodeMessage2(String key, String message) {
        int[] secret = new int[26];
        Arrays.fill(secret, -1);

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            for (int j = 0; j < secret.length; j++) {
                if (secret[j] == index) {
                    break;
                }
                if (secret[j] == -1) {
                    secret[j] = index;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                for (int j = 0; j < secret.length; j++) {
                    if (message.charAt(i) == secret[j] + 'a') {
                        char out = (char) (j + 'a');
                        sb.append(out);
                    }
                }
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    public String decodeMessage(String key, String message) {
        int countHelp = 0;
        HashMap<Character, Character> diction = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ') {
                if (diction.containsKey(key.charAt(i))) {
                    continue;
                } else {
                    diction.put(key.charAt(i), (char) (countHelp++ + 'a'));
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                sb.append(diction.get(message.charAt(i)));
            } else {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}
