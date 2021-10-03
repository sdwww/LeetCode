/**
 * @(#)RobThree.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.TreeNode;

/**
 * 337. 打家劫舍 III
 *
 * @author wangweiwei
 */
public class RobThree {

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

        RobThree robThree = new RobThree();
        int rob = robThree.rob(root);
        System.out.println(rob);

    }

    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 使用当前节点的最大值
        int selected = node.val + left[1] + right[1];
        // 不使用当前节点的最大值
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, notSelected};
    }
}