package everyday.y2022.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 105
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 * 通过次数17,417提交次数36,866
 */
public class MinNumberOfFrogs1419 {
    public static void main(String[] args) {
        MinNumberOfFrogs1419 main = new MinNumberOfFrogs1419();


        String croakOfFrogs = "croakcroak";
        int i = main.minNumberOfFrogs(croakOfFrogs);
        System.out.println(i);

    }

    public int minNumberOfFrogs(String croakOfFrogs) {
//        String replace = croakOfFrogs.replace("croak", "");
//        if (replace.length() == 0) return 1;
        HashMap<Character, List<Integer>> diction = new HashMap<>();
        int count = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char element = croakOfFrogs.charAt(i);
            if (!diction.containsKey(element)) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                diction.put(element, arrayList);
            } else {
                diction.get(element).add(i);
            }

            if (diction.containsKey('k') && diction.get('k').size() != 0) {
                if ((!diction.containsKey('c') || diction.get('c').size() == 0) || (!diction.containsKey('r') || diction.get('r').size() == 0) || (!diction.containsKey('o') || diction.get('o').size() == 0) || (!diction.containsKey('a') || diction.get('a').size() == 0)) {
                    return -1;
                }
                Integer s1 = diction.get('c').remove(0);
                Integer s2 = diction.get('r').remove(0);
                Integer s3 = diction.get('o').remove(0);
                Integer s4 = diction.get('a').remove(0);
                Integer s5 = diction.get('k').remove(0);
                if (s1 < s2 && s2 < s3 && s3 < s4 && s4 < s5) {
                } else {
                    return -1;
                }
            } else {
                int size;
                if (diction.get('c') == null) {
                    size = 0;
                } else {
                    size = diction.get('c').size();
                }
                count = Math.max(size, count);
            }
        }

        for (Character character : diction.keySet()) {
            if (diction.get(character).size() != 0) return -1;
        }
        return count;
    }
}
