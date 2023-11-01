package entity;

import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initTreeNode(Integer[] input) {
        TreeNode firstHead = new TreeNode(input[0]);
        LinkedList<TreeNode> deque = new LinkedList<>();
        LinkedList<TreeNode> helpDeque = new LinkedList<>();
        deque.addLast(firstHead);

        for (int i = 1; i < input.length; i = i + 2) {
            if (deque.size() > 0) {
            }else {
               deque =(LinkedList<TreeNode>) helpDeque.clone();
                helpDeque.clear();
            }

            TreeNode treeNode = deque.pollFirst();
            if (input[i] != null) {
                TreeNode leftTreeNode = new TreeNode(input[i]);
                helpDeque.addLast(leftTreeNode);
                treeNode.left = leftTreeNode;
            }
            if (i + 1 < input.length) {
                if (input[i+1] != null) {
                    TreeNode rightTreeNode = new TreeNode(input[i+1]);
                    helpDeque.addLast(rightTreeNode);
                    treeNode.right = rightTreeNode;
                }
            }
        }
        return firstHead;

    }
}


