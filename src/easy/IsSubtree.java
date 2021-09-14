/**
 * @(#)IsSubtree.java, 9月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import base.TreeNode;

/**
 * 572. 另一棵树的子树
 *
 * @author wangweiwei
 */
public class IsSubtree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode node6 = new TreeNode(20);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(7);
        node6.left = node7;
        node6.right = node8;

        IsSubtree solution = new IsSubtree();
        boolean subtree = solution.isSubtree(root1, node6);
        System.out.println(subtree);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}