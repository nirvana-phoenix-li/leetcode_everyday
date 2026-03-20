package everyday.y2026.january;

import entity.TreeNode;

public class SumRootToLeaf1022 {
    public static void main(String[] args) {

    }

    public int sumRootToLeafRecursion(TreeNode root, int ancestorValue) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return ancestorValue;
        }
        if (root.left != null) {
            sum += sumRootToLeafRecursion(root.left, ancestorValue*2 + root.left.val);
        }
        if (root.right != null) {
            sum += sumRootToLeafRecursion(root.right, ancestorValue*2 + root.right.val);
        }
        return sum;
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumRootToLeafRecursion(root, root.val);
    }
}
