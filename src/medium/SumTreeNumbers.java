package medium;

import base.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * @author www
 */
public class SumTreeNumbers {

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

        SumTreeNumbers solution = new SumTreeNumbers();
        int i = solution.sumNumbers(root);
        System.out.println(i);
    }

    private int result;

    public int sumNumbers(TreeNode root) {
        search(root, 0);
        return result;
    }

    private void search(TreeNode node, int tempSum) {
        tempSum = tempSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            result += tempSum;
            return;
        }
        if (node.left != null) {
            search(node.left, tempSum);
        }

        if (node.right != null) {
            search(node.right, tempSum);
        }
    }
}