/**
 * @(#)SortedArrayToBST.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import base.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author wangweiwei
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode treeNode = solution.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = build(nums, left, mid - 1);
        treeNode.right = build(nums, mid + 1, right);
        return treeNode;
    }
}