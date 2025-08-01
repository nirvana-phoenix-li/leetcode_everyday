package everyday.y2025.june;


/**
 * 45. 跳跃游戏 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 1,011,442/2.2M
 * 通过率
 * 45.0%
 */
public class Jump45 {
    public static void main(String[] args) {

        Jump45 main = new Jump45();
        int[] ints = {2,3,1,1,4};
        int jump = main.jump(ints);
        System.out.println(jump);

    }

    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 0;

        for (int z = 0; z < length; z++) {
            int num = nums[z];
            for (int i = z; i <= z + num && i < length; i++) {

               if(dp[i] == 0){
                   dp[i]=dp[z]+1;
               }else{
                   dp[i]=Math.min(dp[i],dp[z]+1);
               }
            }
        }
        return dp[length-1]-1;
    }
}
