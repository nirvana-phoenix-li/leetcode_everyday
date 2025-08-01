package everyday.y2025.july;

/**
 * 2683. 相邻值的按位异或
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。
 * <p>
 * 特别地，对于范围 [0, n - 1] 内的每个下标 i ：
 * <p>
 * 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
 * 否则 derived[i] = original[i] ⊕ original[i + 1]
 * 给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。
 * <p>
 * 如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。
 * <p>
 * 二进制数组是仅由 0 和 1 组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：derived = [1,1,0]
 * 输出：true
 * 解释：能够派生得到 [1,1,0] 的有效原始二进制数组是 [0,1,0] ：
 * derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1
 * derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
 * derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
 * 示例 2：
 * <p>
 * 输入：derived = [1,1]
 * 输出：true
 * 解释：能够派生得到 [1,1] 的有效原始二进制数组是 [0,1] ：
 * derived[0] = original[0] ⊕ original[1] = 1
 * derived[1] = original[1] ⊕ original[0] = 1
 * 示例 3：
 * <p>
 * 输入：derived = [1,0]
 * 输出：false
 * 解释：不存在能够派生得到 [1,0] 的有效原始二进制数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == derived.length
 * 1 <= n <= 105
 * derived 中的值不是 0 就是 1 。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 12,163/15.9K
 * 通过率
 * 76.7%
 */
public class DoesValidArrayExist2683 {
    public static void main(String[] args) {
        DoesValidArrayExist2683 main = new DoesValidArrayExist2683();
        int[] derived = {1, 1, 0};
        boolean b = main.doesValidArrayExist(derived);
        System.out.println(b);

    }

    public boolean doesValidArrayExist(int[] derived) {
        boolean flag = true;
        for (int i = 0; i < derived.length; i++) {
            if (derived[i] == 1) {
                flag = !flag;
            }
        }
        return flag;
    }

//    public boolean doesValidArrayExist(int[] derived) {
//        //hypothesize method
////
////        if (derived.length == 1) {
////            return true;
////        }
//        int[] original = new int[derived.length];
//
//        //first element is zero,so that the original array first and second element
//        //must equal
//        original[0] = 1;
//        if (derived[0] == 0) {
//            original[1] = 1;
//        } else {
//            original[1] = 0;
//        }
//
//        for (int i = 1; i < derived.length - 1; i++) {
//            int i1 = original[i] ^ original[i + 1];
//            if (derived[i] != i1) {
//                return false;
//            }
//        }
//        if (derived[derived.length - 1] != (original[derived.length - 1] ^ original[0])) {
//            return false;
//        }
//
//        return true;
//    }
}
