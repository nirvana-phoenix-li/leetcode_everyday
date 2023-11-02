package everyday.y2022.may;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 1079. 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * 通过次数22,416提交次数29,213
 */
public class NumTilePossibilities1079 {
    public static void main(String[] args) {

    }

    public int numTilePossibilities(String tiles) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            if (hashMap.containsKey(tiles.charAt(i))) {
                hashMap.put(tiles.charAt(i), hashMap.get(tiles.charAt(i)) + 1);
            } else {
                hashMap.put(tiles.charAt(i), 1);
            }
        }
        for (int i = 1; i <= tiles.length(); i++) {

        }


        HashSet<String> set = new HashSet<>();
        return 0;

    }
}
