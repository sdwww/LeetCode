package medium;

import base.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {

    private Integer preValue = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(18);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        IsValidBST inorderTraversal = new IsValidBST();
        System.out.println(inorderTraversal.isValidBST(root));
    }

    /**
     * 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (preValue != null && root.val <= preValue) {
            return false;
        }
        preValue = root.val;
        return isValidBST(root.right);
    }


    /**
     * 逻辑比较复杂
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && getMaxValue(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && getMinValue(root.right) <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private Integer getMaxValue(TreeNode treeNode) {
        if (treeNode == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(treeNode.val, getMaxValue(treeNode.right)), getMaxValue(treeNode.left));
    }

    private Integer getMinValue(TreeNode treeNode) {
        if (treeNode == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(treeNode.val, getMinValue(treeNode.right)), getMinValue(treeNode.left));
    }
}
