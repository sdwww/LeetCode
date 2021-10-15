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
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode preEnd = dummy;
        for (int i = 1; i < left; i++) {
            preEnd = preEnd.next;
        }
        ListNode currentStart = preEnd.next;
        ListNode currentEnd = preEnd;
        for (int i = 0; i < right - left + 1; i++) {
            currentEnd = currentEnd.next;
        }
        ListNode nextStart = currentEnd.next;
        currentEnd.next = null;
        preEnd.next = reverseList(currentStart);
        currentStart.next = nextStart;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head.next.next;
        ListNode next = head.next;
        ListNode last = head;
        last.next = null;
        while (first != null) {
            next.next = last;
            last = next;
            next = first;
            first = first.next;
        }
        next.next = last;
        return next;
    }
}
