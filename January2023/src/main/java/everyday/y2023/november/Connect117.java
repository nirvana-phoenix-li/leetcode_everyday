package everyday.y2023.november;

import entity.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 * 通过次数
 * 205.8K
 * 提交次数
 * 308.9K
 * 通过率
 * 66.6%
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 */
public class Connect117 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while (stack.size() != 0) {
            Deque<Node> innerStack = new LinkedList<>();
            Node headNode = new Node();
            while (stack.size() != 0) {
                Node poll = stack.poll();
                Node left = poll.left;
                if (left != null) {
                    headNode.next = left;
                    headNode = left;
                    innerStack.addLast(left);
                }
                Node right = poll.right;
                if (right != null) {
                    headNode.next = right;
                    headNode = right;
                    innerStack.addLast(right);
                }
            }
            stack = innerStack;
        }
        return root;
    }
}

