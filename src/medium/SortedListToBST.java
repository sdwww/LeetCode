/**
 * @(#)SortedListToBST.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.ListNode;
import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author wangweiwei
 */
public class SortedListToBST {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SortedListToBST solution = new SortedListToBST();
        TreeNode treeNode = solution.sortedListToBST(node1);
        System.out.println(treeNode);
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(list.get(left));
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = build(list, left, mid - 1);
        treeNode.right = build(list, mid + 1, right);
        return treeNode;
    }
}