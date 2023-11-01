package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1282. 用户分组
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 * <p>
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 * <p>
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 * <p>
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 第一组是 [5]，大小为 1，groupSizes[5] = 1。
 * 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
 * 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 示例 2：
 * <p>
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 * 通过次数49,364提交次数57,086
 */
public class GroupThePeople1282 {
    public static void main(String[] args) {
        GroupThePeople1282 main = new GroupThePeople1282();
        int[] ints = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> lists = main.groupThePeople(ints);
        System.out.println(lists);

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (hashMap.containsKey(groupSizes[i])) {
                hashMap.get(groupSizes[i]).add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(groupSizes[i], arrayList);
            }
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            List<Integer> list = hashMap.get(integer);
            int help = list.size() / integer;
            int count = 1;
            while (count <= help) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int i = (count - 1) * integer; i < count * integer; i++) {
                    tempList.add(list.get(i));
                }
                lists.add(tempList);
                count++;
            }
        }
        return lists;
    }
}
