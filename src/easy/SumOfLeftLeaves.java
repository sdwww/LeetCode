package easy;

import base.TreeNode;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {

    private int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        int i = solution.sumOfLeftLeaves(root);
        System.out.println(i);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        search(root.left, true);
        search(root.right, false);
        return sum;
    }

    private void search(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }
        search(node.left, true);
        search(node.right, false);
    }
}
