package easy;

import base.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author www
 */
public class DiameterOfBinaryTree {

    int max = 0;

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

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int i = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(i);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int result = 0;
        TreeNode treeNode = root;
        while (treeNode != null) {
            // 获取左子树和右子树的深度
            int leftDepth = getDepth(treeNode.left);
            int rightDepth = getDepth(treeNode.right);
            // 优化，如果左子树和右子树的最大值的两倍都不能大于result，终止循环
            if (Math.max(leftDepth, rightDepth) * 2 <= result) {
                break;
            }
            result = Math.max(result, leftDepth + rightDepth);
            // 哪个子树深向哪里走
            if (leftDepth > rightDepth) {
                treeNode = treeNode.left;
            } else {
                treeNode = treeNode.right;
            }
        }
        return result;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}