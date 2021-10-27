package medium;

import base.ListNode;

/**
 * 148. 排序链表
 */
public class SortLinkedList {

    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(sortLinkedList.sortList(node1));
    }

    // 时间复杂度O(nlogn)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode newHead = middle.next;
        middle.next = null;
        ListNode sort1 = sortList(head);
        ListNode sort2 = sortList(newHead);
        return mergeSort(sort1, sort2);
    }

    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (current1 != null && current2 != null) {
            if (current1.val > current2.val) {
                current.next = current2;
                current2 = current2.next;
            } else {
                current.next = current1;
                current1 = current1.next;
            }
            current = current.next;
        }
        if (current1 != null) {
            current.next = current1;
        }
        if (current2 != null) {
            current.next = current2;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
