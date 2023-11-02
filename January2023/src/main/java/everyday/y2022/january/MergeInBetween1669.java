package everyday.y2022.january;

import entity.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 * 通过次数28,149提交次数36,865
 */
public class MergeInBetween1669 {
    public static void main(String[] args) {
        /**
         * [0,1,2,3,4,5,6]
         * 2
         * 5
         * [1000000,1000001,1000002,1000003,1000004]
         */
        MergeInBetween1669 main = new MergeInBetween1669();
        List<Integer> firstList = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(1000000, 1000001, 1000002);
        ListNode constructor1 = constructor(firstList);
        ListNode constructor2 = constructor(secondList);

        ListNode listNode = main.mergeInBetween(constructor1, 3, 4, constructor2);
        System.out.println(listNode);

    }

    public static ListNode constructor(List<Integer> arrs) {
        ListNode dummyHead = new ListNode();
        ListNode initial = dummyHead;
        for (Integer arr : arrs) {
            ListNode listNode = new ListNode(arr);

            dummyHead.next = listNode;
            dummyHead = dummyHead.next;
        }
        return initial.next;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode initialHead = list1;
        int count = b - a+2;
        while (--a > 0) {
            list1 = list1.next;
        }
        ListNode temp = list1;
        while (count-- > 0) {
            temp = temp.next;
        }

        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = temp;
        return initialHead;
    }
}
