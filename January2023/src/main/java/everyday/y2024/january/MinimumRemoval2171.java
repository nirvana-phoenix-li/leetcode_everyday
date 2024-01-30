package everyday.y2024.january;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2171. 拿出最少数目的魔法豆
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * <p>
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * <p>
 * 请返回你需要拿出魔法豆的 最少数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beans = [4,1,6,5]
 * 输出：4
 * 解释：
 * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,6,5]
 * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,5]
 * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,4]
 * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 4 个魔法豆更少的方案。
 * 示例 2：
 * <p>
 * 输入：beans = [2,10,3,2]
 * 输出：7
 * 解释：
 * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,2]
 * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,0]
 * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,0,0]
 * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 7 个魔法豆更少的方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beans.length <= 105
 * 1 <= beans[i] <= 105
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 * 社招
 * 校招
 * 实习
 * 未遇到
 * 通过次数
 * 17.3K
 * 提交次数
 * 37.6K
 * 通过率
 * 46.0%
 */
public class MinimumRemoval2171 {

    public static void main(String[] args) {
        MinimumRemoval2171 main = new MinimumRemoval2171();
        int[] ints = {4,1,6,5};
        long l = main.minimumRemoval(ints);
        System.out.println(l);
    }

    public long minimumRemoval(int[] beans) {
        HashMap<Long, Long> hashMap = new HashMap<>();
        for (int bean : beans) {
            if (hashMap.containsKey((long)bean)) {
                hashMap.put((long) bean, hashMap.get((long)bean) + 1);
            } else {
                hashMap.put((long)bean, 1L);
            }
        }

        List<Long> sortedKey = hashMap.keySet().stream().sorted(Comparator.comparingLong(a -> a)).collect(Collectors.toList());
        long answer = Long.MAX_VALUE;
        long help = 0;
        int allNumber = beans.length;
        for (int j = 1; j < sortedKey.size(); j++) {
            help += hashMap.get(sortedKey.get(j)) * (sortedKey.get(j) - sortedKey.get(0));
        }
        answer = Math.min(help, answer);
        allNumber -= hashMap.get(sortedKey.get(0));


        for (int j = 1; j < sortedKey.size(); j++) {
            help = help + hashMap.get(sortedKey.get(j - 1)) * (sortedKey.get(j - 1));
            help = help -(allNumber*(sortedKey.get(j )-sortedKey.get(j - 1)));
            allNumber -= hashMap.get(sortedKey.get(j));
            answer = Math.min(help, answer);
        }
        return answer;
    }
}
