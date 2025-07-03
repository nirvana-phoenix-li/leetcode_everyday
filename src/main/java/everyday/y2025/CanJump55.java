package everyday.y2025;

/**
 * 55. 跳跃游戏
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 1,286,863/2.9M
 * 通过率
 * 43.9%
 */
public class CanJump55 {

    public static void main(String[] args) {

        CanJump55 main = new CanJump55();
        int[] ints = {3,2,1,0,4};
        boolean b = main.canJump(ints);
        System.out.println(b);

    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[length - 1] = true;

        for (int z = length - 2; z >= 0; z--) {
            int num = nums[z];
            boolean flag = false;
            for (int i = z; i <= z + num && i < length; i++) {
                if (dp[i]) {
                    flag = true;
                    break;
                }
            }
            dp[z] = flag;
        }
        return dp[0];
    }
}
