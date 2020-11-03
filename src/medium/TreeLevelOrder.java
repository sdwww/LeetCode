package medium;

import base.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class TreeLevelOrder {


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

        TreeLevelOrder solution = new TreeLevelOrder();
        Arrays.stream(solution.levelOrder(root)).forEach(System.out::println);
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> valueList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            valueList.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return valueList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
