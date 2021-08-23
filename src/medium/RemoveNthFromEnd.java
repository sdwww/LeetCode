package medium;

import base.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author www
 */
public class RemoveNthFromEnd {

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

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = removeNthFromEnd.removeNthFromEnd(listNode1, 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode kthFromEnd = getKthFromEnd(head, n);
        if (kthFromEnd == head) {
            return head.next;
        }
        ListNode kAddOneFromEnd = getKthFromEnd(head, n + 1);
        kAddOneFromEnd.next = kthFromEnd.next;
        return head;
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