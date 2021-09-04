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
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

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
                if (node.left != null) {

                }
                if (node.right != null) {

                }
            }
        }
        return false;
    }
}
