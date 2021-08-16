package easy;

import base.TreeNode;

/**
 * 226. 翻转二叉树
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {

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

        MirrorTree solution = new MirrorTree();
        System.out.println(solution.mirrorTree(root));
    }

    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    private void mirror(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode treeNodeTemp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = treeNodeTemp;
        mirror(treeNode.left);
        mirror(treeNode.right);
    }
}
