/**
 * @(#)GetMinimumDifference.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import base.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author wangweiwei
 */
public class GetMinimumDifference {

    private Integer preVal;

    private int result = Integer.MAX_VALUE;

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

        GetMinimumDifference solution = new GetMinimumDifference();
        int minimumDifference = solution.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    // 中序遍历
    public int getMinimumDifference(TreeNode root) {
        search(root);
        return result;
    }

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        if (preVal != null) {
            result = Math.min(result, node.val - preVal);
        }
        preVal = node.val;
        search(node.right);
    }
}