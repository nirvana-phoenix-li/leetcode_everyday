package everyday.may;


import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * 通过次数26,234提交次数38,751
 */
public class DelNodes1110 {

    List<TreeNode> treeNodeList = new ArrayList<>();
    int[] to_delete = new int[]{};

    public static void main(String[] args) {
        DelNodes1110 main = new DelNodes1110();

//        [1,2,null,4,3]
//[2,3]
        Integer[] ints = {1, 2, null, 4, 3};
        int[] to_delete = {2, 3};
        TreeNode root = TreeNode.initTreeNode(ints);
        List<TreeNode> treeNodes = main.delNodes(root, to_delete);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.val);
        }

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.to_delete = to_delete;

        findTree(root);


        return treeNodeList;
    }

    private boolean isContain(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) return true;
        }
        return false;
    }

    private void findTree(TreeNode root) {
        if (root == null) {
        } else {
            if (isContain(to_delete, root.val)) {
                findTree(root.left);
                findTree(root.right);
                root = null;
            } else {
                ArrayList<TreeNode> arrayList = new ArrayList<>();
                arrayList.add(root);
                treeNodeList.add(root);

                while (arrayList.size() != 0) {
                    ArrayList<TreeNode> innerList = new ArrayList<>();
                    for (TreeNode treeNode : arrayList) {
                        TreeNode leftNode = treeNode.left;
                        if (leftNode != null) {
                            if (isContain(to_delete, leftNode.val)) {
//                            treeNodeList.add(leftNode.left);
                                findTree(leftNode.left);
//                            treeNodeList.add(leftNode.right);
                                findTree(leftNode.right);
                                treeNode.left = null;
                            } else {
                                innerList.add(leftNode);
                            }
                        }

                        TreeNode rightNode = treeNode.right;
                        if (rightNode != null) {
                            if (isContain(to_delete, rightNode.val)) {
//                            treeNodeList.add(rightNode.left);
                                findTree(rightNode.left);
//                            treeNodeList.add(rightNode.right);
                                findTree(rightNode.right);
                                treeNode.right = null;
                            } else {
                                innerList.add(rightNode);
                            }
                        }
                    }
                    arrayList = (ArrayList<TreeNode>) innerList.clone();
                    innerList.clear();
                }
            }

        }
    }

}
