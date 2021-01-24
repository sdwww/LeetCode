package easy;

import base.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(5);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(mergeTwoLists.mergeTwoLists(listNode1, listNode4));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }
}
