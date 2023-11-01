package question;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LCP 67. 装饰树
 * 力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
 * <p>
 * 完成装饰的二叉树根结点与 root 的根结点值相同
 * 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 * 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 * 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
 * 现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
 * 示例 1：
 * <p>
 * 输入：
 * root = [7,5,6]
 * <p>
 * 输出：[7,-1,-1,5,null,null,6]
 * <p>
 * 解释：如下图所示，
 * image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * root = [3,1,7,3,8,null,4]
 * <p>
 * 输出：[3,-1,-1,1,null,null,7,-1,-1,null,-1,3,null,null,8,null,4]
 * <p>
 * 解释：如下图所示
 * image.png
 * <p>
 * 提示：
 * <p>
 * 0 <= root.Val <= 1000
 * root 节点数量范围为 [1, 10^5]
 * <p>
 * 通过次数5,023提交次数5,714
 */
public class ExpandBinaryTreeLCP67 {
    public TreeNode expandBinaryTree(TreeNode root) {
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        while (treeNodes.size() != 0) {
            TreeNode currentNode = treeNodes.pollFirst();
            if (currentNode.left != null){
                TreeNode tempNode = new TreeNode(-1);
                tempNode.left=currentNode.left;
                currentNode.left= tempNode;
                treeNodes.addLast(tempNode.left);
            }
            if (currentNode.right != null){
                TreeNode tempNode = new TreeNode(-1);
                tempNode.right=currentNode.right;
                currentNode.right= tempNode;
                treeNodes.addLast(tempNode.right);
            }
        }
        return root;
    }
}
