package medium;

import base.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author www
 */
public class TreeSubStructure {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeSubStructure solution = new TreeSubStructure();
        boolean subStructure = solution.isSubStructure(root, node4);
        System.out.println(subStructure);
    }

    // 双递归，以A的没一个节点和B进行比较
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (same(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean same(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return same(A.left, B.left) && same(A.right, B.right);
    }
}