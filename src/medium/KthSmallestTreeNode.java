/**
 * @(#)KthSmallestTreeNode.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author wangweiwei
 */
public class KthSmallestTreeNode {

    private int currentIndex = 0;
    private int value = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(13);
        TreeNode node4 = new TreeNode(17);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        KthSmallestTreeNode solution = new KthSmallestTreeNode();
        int i = solution.kthSmallest(root, 2);
        System.out.println(i);
    }


    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return value;
    }

    private void search(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        search(node.left, k);
        currentIndex++;
        if (currentIndex == k) {
            value = node.val;
            return;
        }
        search(node.right, k);
    }
}