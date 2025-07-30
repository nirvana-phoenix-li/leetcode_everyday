package everyday.y2025;

import entity.ListNode;

/**
 * 1290. 二进制链表转整数
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 最高位 在链表的头部。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 111,286/137.8K
 * 通过率
 * 80.8%
 */
public class GetDecimalValue1290 {
    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        if (head.val == 0) {
            return 0;
        }

        int original = 1;
        do {
            if (head.val == 1) {
                original++;
            }

            head = head.next;
            original = original * 2;
        } while (head.next != null);
        return original;
    }
}
