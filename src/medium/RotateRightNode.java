package medium;

import base.ListNode;

/**
 * 61. 旋转链表
 *
 * @author wangweiwei
 */
public class RotateRightNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RotateRightNode solution = new RotateRightNode();
        ListNode listNode = solution.rotateRight(node1, 1);
        System.out.println(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        // 反转之后和原链表一致
        if (k == 0) {
            return head;
        }
        ListNode lastNode = getKthFromEnd(head, 1);
        ListNode kthPlusOneFromEnd = getKthFromEnd(head, k + 1);
        ListNode newHead = kthPlusOneFromEnd.next;
        lastNode.next = head;
        kthPlusOneFromEnd.next = null;
        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }
}