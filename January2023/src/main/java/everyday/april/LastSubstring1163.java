package everyday.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："tcode"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 4 * 105
 * s 仅含有小写英文字符。
 * 通过次数12,650提交次数40,003
 */
public class LastSubstring1163 {
    public static void main(String[] args) {
        LastSubstring1163 main = new LastSubstring1163();
        String s = main.lastSubstring("abab");
        System.out.println(s);
    }

    public String lastSubstring(String s) {
        HashMap<Character, List<Integer>> listHashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!listHashMap.containsKey(s.charAt(i))) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                listHashMap.put(s.charAt(i), arrayList);
            } else {
                List<Integer> list = listHashMap.get(s.charAt(i));
                list.add(i);
            }
        }

        int temp = 122;
        List<Integer> list = new ArrayList<>();
        while (temp > 50) {
            char key = (char) temp;
            if (listHashMap.containsKey(key)) {
                list = listHashMap.get(key);
                break;
            }
            temp--;
        }
        while (list.size() > 1) {
            List<Integer> arrayList = new ArrayList<>();
            listHashMap.clear();
            for (int i = 0; i < list.size(); i++) {
                Integer index = list.get(i);
                if (index + 1 < s.length()) {
                    if (!listHashMap.containsKey(s.charAt(i))) {
                        arrayList.add(i);
                        listHashMap.put(s.charAt(index + 1), arrayList);
                    } else {
                        List<Integer> list2 = listHashMap.get(s.charAt(index + 1));
                        list2.add(index + 1);
                    }
                }
            }
            temp = 122;
            while (temp > 50) {
                char key = (char) temp;
                if (listHashMap.containsKey(key)) {
                    arrayList = listHashMap.get(key);
                    break;
                }
                temp--;
            }
            list = arrayList;
        }

        return s.substring(list.get(0));
    }
}
