package everyday.y2025.october;

/**
 * 3147. 从魔法师身上吸取的最大能量
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在神秘的地牢中，n 个魔法师站成一排。每个魔法师都拥有一个属性，这个属性可以给你提供能量。有些魔法师可能会给你负能量，即从你身上吸取能量。
 * <p>
 * 你被施加了一种诅咒，当你从魔法师 i 处吸收能量后，你将被立即传送到魔法师 (i + k) 处。这一过程将重复进行，直到你到达一个不存在 (i + k) 的魔法师为止。
 * <p>
 * 换句话说，你将选择一个起点，然后以 k 为间隔跳跃，直到到达魔法师序列的末端，在过程中吸收所有的能量。
 * <p>
 * 给定一个数组 energy 和一个整数k，返回你能获得的 最大 能量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： energy = [5,2,-10,-5,1], k = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：可以从魔法师 1 开始，吸收能量 2 + 1 = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： energy = [-2,-3,-1], k = 2
 * <p>
 * 输出： -1
 * <p>
 * 解释：可以从魔法师 2 开始，吸收能量 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= energy.length <= 105
 * -1000 <= energy[i] <= 1000
 * 1 <= k <= energy.length - 1
 * <p>
 * <p>
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 9,220/17.5K
 * 通过率
 * 52.8%
 */
public class MaximumEnergy3147 {
    public static void main(String[] args) {

        MaximumEnergy3147 main = new MaximumEnergy3147();
//        [5,2,-10,-5,1], k = 3
        int[] ints = {-2,-3,-1};
        int i = main.maximumEnergy(ints, 2);
        System.out.println(i);

    }

    public int maximumEnergy(int[] energy, int k) {
        int maxValue = Integer.MIN_VALUE;
        int length = energy.length;
        int[] dp = new int[length];

        for (int z = length - 1; z >= 0; z--) {
            if ((z + k+1) > length) {
                dp[z] = energy[z];
            } else {
                dp[z] = energy[z] + dp[z + k];
            }
            maxValue=Math.max(maxValue,dp[z]);
        }
        return maxValue;
    }


//    public int maximumEnergy(int[] energy, int k) {
//        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < k; i++) {
//            int temp = 0;
//            for (int j = i; j < energy.length; j += k) {
//                temp += energy[j];
//            }
//            maxValue = Math.max(maxValue, temp);
//        }
//        return maxValue;
//    }
}
