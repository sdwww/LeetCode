package easy;

import base.TreeNode;

/**
 * 110. 平衡二叉树
 */
public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        IsBalancedTree isBalancedTree = new IsBalancedTree();
        System.out.println(isBalancedTree.isBalanced(root));
    }

    // 时间复杂度O(n)
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 获取高度，如果不平衡返回-1;
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 时间复杂度O(n2)
    public boolean isBalanced1(TreeNode root) {
        // 节点为空返回true
        if (root == null) {
            return true;
        }
        //如果左右深度超过1，返回false
        if (Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) > 1) {
            return false;
        }
        // 否则遍历子节点是否为平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 获取节点的深度
    private int getDepth(TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return depth;
        }
        return Math.max(getDepth(treeNode.left, depth + 1), getDepth(treeNode.right, depth + 1));
    }
}
