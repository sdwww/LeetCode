package medium;

import base.ListNode;

/**
 * 92. 反转链表 II
 */
public class ReverseBetweenList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ReverseBetweenList betweenList = new ReverseBetweenList();
        System.out.println(betweenList.reverseBetween(listNode1, 1, 2));

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        // 将链表分成三段，中间段反转，标记四个节点
        ListNode listNode = head;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode node3 = null;
        ListNode node4 = null;
        int count = 1;
        while (listNode != null) {
            if (count == left - 1) {
                node1 = listNode;
            }
            if (count == left) {
                node2 = listNode;
            }
            if (count == right) {
                node3 = listNode;
            }
            if (count == right + 1) {
                node4 = listNode;
            }
            listNode = listNode.next;
            count++;
        }
        reverseList(node2, node3);
        if (node1 != null) {
            node1.next = node3;
        }
        if (node2 != null) {
            node2.next = node4;
        }
        if (node1 == null) {
            return node3;
        }
        return head;
    }

    private void reverseList(ListNode node1, ListNode node2) {
        if (node1 == null || node1.next == null) {
            return;
        }
        ListNode first = node1.next.next;
        ListNode next = node1.next;
        ListNode last = node1;
        last.next = null;
        while (first != null && next != node2) {
            next.next = last;
            last = next;
            next = first;
            first = first.next;
        }
        next.next = last;
    }
}
