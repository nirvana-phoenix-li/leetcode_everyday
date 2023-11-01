package everyday.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 2451. 差值数组不同的字符串
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 * 通过次数10,111提交次数15,460
 */
public class OddString2451 {
    public static void main(String[] args) {
        OddString2451 main = new OddString2451();
        String[] strings = {"aaa","bob","ccc","ddd"};
        String s = main.oddString(strings);
        System.out.println(s);

    }

    public String oddString(String[] words) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        boolean flag = false;
        for (String word : words) {
            if (arrayList.size() == 0) {
                ArrayList<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < word.length() - 1; i++) {
                    char a = word.charAt(i);
                    char b = word.charAt(i + 1);
                    int i1 = b - a;
                    innerList.add(i1);
                }
                arrayList.add(innerList);
                names.add(word);
            } else if (arrayList.size() == 1) {
                ArrayList<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < word.length() - 1; i++) {
                    char a = word.charAt(i);
                    char b = word.charAt(i + 1);
                    int i1 = b - a;
                    innerList.add(i1);
                }
                boolean innerFlag = true;
                for (int i = 0; i < innerList.size(); i++) {
                    Integer integer = arrayList.get(0).get(i);
                    Integer integer1 = innerList.get(i);
                    if (!Objects.equals(integer, integer1)) {
                        innerFlag = false;
                    }
                }
                if (innerFlag) {
                    flag = true;
                } else {
                    if (flag) {
                        return word;
                    } else {
                        names.add(word);
                        arrayList.add(innerList);
                    }
                }
            } else if (arrayList.size() == 2) {
                ArrayList<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < word.length() - 1; i++) {
                    char a = word.charAt(i);
                    char b = word.charAt(i + 1);
                    int i1 = b - a;
                    innerList.add(i1);
                }

                for (int z = 0; z < 2; z++) {
                    boolean innerFlag = true;
                    for (int i = 0; i < innerList.size(); i++) {
                        Integer integer = arrayList.get(z).get(i);
                        Integer integer1 = innerList.get(i);
                        if (!Objects.equals(integer, integer1)) {
                            innerFlag = false;
                        }
                    }
                    if (innerFlag) {
                        return names.get(1 - z);
                    } else {
                        continue;
                    }
                }
            }
        }
        return "";
    }
}
