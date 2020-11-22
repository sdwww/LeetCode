package medium;

import base.TreeNode;

/**
 * 814. 二叉树剪枝
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        PruneTree solution = new PruneTree();
        System.out.println(solution.pruneTree(root));
    }

    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    private TreeNode prune(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = prune(node.left);
        node.right = prune(node.right);
        if (node.val == 0 && node.left == null && node.right == null) {
            return null;
        }
        return node;
    }
}
