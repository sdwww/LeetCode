package medium;

import base.TreeNode;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/8/15 11:50
 * Description:865. 具有所有最深结点的最小子树
 */
public class SubtreeWithAllDeepest {

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

        SubtreeWithAllDeepest solution = new SubtreeWithAllDeepest();
        System.out.println(solution.subtreeWithAllDeepest(root));
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth = 0;
        return search(root, depth);
    }

    private TreeNode search(TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return null;
        }
        int leftDepth = getDepth(treeNode.left, depth);
        int rightDepth = getDepth(treeNode.right, depth);
        if (leftDepth == rightDepth) {
            return treeNode;
        }
        depth++;
        if(leftDepth>rightDepth){
            return search(treeNode.left,depth);
        }
        return search(treeNode.right,depth);


    }

    private int getDepth(TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return depth;
        }
        depth++;
        int leftDepth = getDepth(treeNode.left, depth);
        int rightDepth = getDepth(treeNode.right, depth);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
