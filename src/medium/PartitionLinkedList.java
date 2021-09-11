/**
 * @(#)PartitionLinkedList.java, 9月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.ListNode;

/**
 * 86. 分隔链表
 *
 * @author wangweiwei
 */
public class PartitionLinkedList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        PartitionLinkedList solution = new PartitionLinkedList();
        ListNode partition = solution.partition(node1, 2);
        System.out.println(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }

        node1.next = dummy2.next;
        // 避免出现环
        node2.next = null;
        return dummy1.next;
    }
}