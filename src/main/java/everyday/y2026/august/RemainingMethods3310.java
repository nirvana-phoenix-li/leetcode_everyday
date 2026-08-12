package everyday.y2026.august;

import java.util.List;

/**
 * 3310. 移除可疑的方法
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。
 * <p>
 * 给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。
 * <p>
 * 已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。
 * <p>
 * 只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。
 * <p>
 * 返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
 * <p>
 * 输出: [0,1,2,3]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 方法 2 和方法 1 是可疑方法，但它们分别直接被方法 3 和方法 0 调用。由于方法 3 和方法 0 不是可疑方法，我们无法移除任何方法，故返回所有方法。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
 * <p>
 * 输出: [3,4]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 方法 0、方法 1 和方法 2 是可疑方法，且没有被任何其他方法直接调用。我们可以移除它们。
 * <p>
 * 示例 3:
 * <p>
 * 输入: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
 * <p>
 * 输出: []
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 所有方法都是可疑方法。我们可以移除它们。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * 0 <= k <= n - 1
 * 0 <= invocations.length <= 2 * 105
 * invocations[i] == [ai, bi]
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * invocations[i] != invocations[j]
 * <p>
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 8,635/16.5K
 * 通过率
 * 52.4%
 */
public class RemainingMethods3310 {
    public static void main(String[] args) {

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        return null;
    }
}
