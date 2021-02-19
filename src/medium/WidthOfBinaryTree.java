package medium;

import base.TreeNode;

import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 */
public class WidthOfBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        int i = widthOfBinaryTree.widthOfBinaryTree(root);
        System.out.println(i);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        // 层次遍历,通过val记录数值，差值为宽度
        while (!queue.isEmpty()) {
            int n = queue.size();
            if (queue.getLast().val - queue.getFirst().val + 1 > max) {
                max = queue.getLast().val - queue.getFirst().val + 1;
            }
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null && treeNode.left != null) {
                    treeNode.left.val = treeNode.val * 2;
                    queue.add(treeNode.left);
                }
                if (treeNode != null && treeNode.right != null) {
                    treeNode.right.val = treeNode.val * 2 + 1;
                    queue.add(treeNode.right);
                }
            }
        }
        return max;
    }
}
