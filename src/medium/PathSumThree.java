package medium;

import base.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author wangweiwei
 */
public class PathSumThree {

    int count = 0;

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

        PathSumThree solution = new PathSumThree();
        int i = solution.pathSum(root, 3);
        System.out.println(i);
    }

    // 双递归
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        search(root, targetSum);
        return count;
    }

    // 使用每个节点作为开头
    public void search(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        count(node, 0, target);
        search(node.left, target);
        search(node.right, target);
    }

    // 基于每个节点，对其子树进行求和
    public void count(TreeNode node, int sum, int target) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            count++;
        }
        count(node.left, sum, target);
        count(node.right, sum, target);
    }
}