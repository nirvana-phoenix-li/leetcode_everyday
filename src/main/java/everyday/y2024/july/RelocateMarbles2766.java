package everyday.y2024.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 2766. 重新放置石块
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 moveTo 。
 * <p>
 * 在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 moveTo[i] 。
 * <p>
 * 完成这些操作后，请你按升序返回所有 有 石块的位置。
 * <p>
 * 注意：
 * <p>
 * 如果一个位置至少有一个石块，我们称这个位置 有 石块。
 * 一个位置可能会有多个石块。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,6,7,8], moveFrom = [1,7,2], moveTo = [2,9,5]
 * 输出：[5,6,8,9]
 * 解释：一开始，石块在位置 1,6,7,8 。
 * 第 i = 0 步操作中，我们将位置 1 处的石块移到位置 2 处，位置 2,6,7,8 有石块。
 * 第 i = 1 步操作中，我们将位置 7 处的石块移到位置 9 处，位置 2,6,8,9 有石块。
 * 第 i = 2 步操作中，我们将位置 2 处的石块移到位置 5 处，位置 5,6,8,9 有石块。
 * 最后，至少有一个石块的位置为 [5,6,8,9] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,3,3], moveFrom = [1,3], moveTo = [2,2]
 * 输出：[2]
 * 解释：一开始，石块在位置 [1,1,3,3] 。
 * 第 i = 0 步操作中，我们将位置 1 处的石块移到位置 2 处，有石块的位置为 [2,2,3,3] 。
 * 第 i = 1 步操作中，我们将位置 3 处的石块移到位置 2 处，有石块的位置为 [2,2,2,2] 。
 * 由于 2 是唯一有石块的位置，我们返回 [2] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= moveFrom.length <= 105
 * moveFrom.length == moveTo.length
 * 1 <= nums[i], moveFrom[i], moveTo[i] <= 109
 * 测试数据保证在进行第 i 步操作时，moveFrom[i] 处至少有一个石块。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 14.9K
 * 提交次数
 * 23.8K
 * 通过率
 * 62.6%
 */
public class RelocateMarbles2766 {
    public static void main(String[] args) {
        RelocateMarbles2766 main = new RelocateMarbles2766();

    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            hashSet.remove(moveFrom[i]);
            hashSet.add(moveTo[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        return list;
    }
}
