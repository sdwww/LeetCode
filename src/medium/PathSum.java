/**
 * @(#)PathSum.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.TreeNode;

/**
 * 112. 路径总和
 *
 * @author www
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum solution = new PathSum();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        boolean b = solution.hasPathSum(root, 29);
        System.out.println(b);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null && targetSum == root.val) {
            return true;
        }
        boolean leftResult = hasPathSum(root.left, targetSum - root.val);
        if (leftResult) {
            return true;
        }
        return hasPathSum(root.right, targetSum - root.val);
    }
}