package medium;

import base.TreeNode;

import java.util.LinkedList;

/**
 * 958. 二叉树的完全性检验
 */
public class IsCompleteTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(66);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        IsCompleteTree isCompleteTree = new IsCompleteTree();
        boolean completeTree = isCompleteTree.isCompleteTree(root);
        System.out.println(completeTree);
    }

    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 碰到第一个null元素，队列中剩下的所有元素必须都是null
                if (node == null) {
                    for (TreeNode treeNode : queue) {
                        if (treeNode != null) {
                            return false;
                        }
                    }
                    return true;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
