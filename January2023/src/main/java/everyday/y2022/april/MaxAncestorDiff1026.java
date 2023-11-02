package everyday.y2022.april;

import entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

public class MaxAncestorDiff1026 {
    public static void main(String[] args) {
//        Integer[] integers = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        Integer[] integers = {1, null, 2, null, 0, 3};
        TreeNode treeNode = TreeNode.initTreeNode(integers);

        MaxAncestorDiff1026 main = new MaxAncestorDiff1026();
        int i = main.maxAncestorDiff(treeNode);
        System.out.println(i);

    }

    public int maxAncestorDiff(TreeNode root) {
        HashMap<TreeNode, int[]> nodeHashMap = new HashMap<>();
        nodeHashMap.put(root, new int[]{root.val, root.val});
        LinkedList<TreeNode> deque = new LinkedList<>();
        LinkedList<TreeNode> helpDeque = new LinkedList<>();
        deque.addLast(root);
        int result = 0;
        while (deque.size() != 0 || helpDeque.size() != 0) {
            if (deque.size() == 0) {
                deque = (LinkedList<TreeNode>) helpDeque.clone();
                helpDeque.clear();
            }
            TreeNode node = deque.pollFirst();
            if (node.left != null) {
                int min = Integer.min(node.left.val, nodeHashMap.get(node)[0]);
                int max = Integer.max(node.left.val, nodeHashMap.get(node)[1]);
                nodeHashMap.put(node.left, new int[]{min, max});
                helpDeque.addLast(node.left);
                result = Integer.max(result, max - min);
            }
            if (node.right != null) {
                int min = Integer.min(node.right.val, nodeHashMap.get(node)[0]);
                int max = Integer.max(node.right.val, nodeHashMap.get(node)[1]);
                nodeHashMap.put(node.right, new int[]{min, max});
                helpDeque.addLast(node.right);
                result = Integer.max(result, max - min);

            }
        }
        return result;
    }
}
