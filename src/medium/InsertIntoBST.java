/**
 * @(#)InsertIntoBST.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author wangweiwei
 */
public class InsertIntoBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(9);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(27);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        InsertIntoBST solution = new InsertIntoBST();
        TreeNode treeNode = solution.insertIntoBST(root, 8);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}