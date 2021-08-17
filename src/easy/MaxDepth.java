package easy;

import base.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author www
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        MaxDepth maxDepth = new MaxDepth();
        int depth = maxDepth.maxDepth(root);
        System.out.println(depth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}