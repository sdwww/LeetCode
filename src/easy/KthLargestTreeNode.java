package easy;

import base.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargestTreeNode {

    private int current = 0;
    private int value = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(13);
        TreeNode node4 = new TreeNode(17);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        KthLargestTreeNode solution = new KthLargestTreeNode();
        int i = solution.kthLargest(root, 3);
        System.out.println(i);
    }

    public int kthLargest(TreeNode root, int k) {
        search(root, k);
        return value;
    }

    private void search(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        search(node.right, k);
        current++;
        if (current == k) {
            value = node.val;
            return;
        }
        search(node.left, k);
    }
}
