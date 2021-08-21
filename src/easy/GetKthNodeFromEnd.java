package easy;

import base.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author www
 */
public class GetKthNodeFromEnd {

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
        GetKthNodeFromEnd solution = new GetKthNodeFromEnd();
        ListNode kthFromEnd = solution.getKthFromEnd(listNode1, 4);
        System.out.println(kthFromEnd);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
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