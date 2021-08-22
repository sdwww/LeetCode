package easy;

import base.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * @author www
 */
public class DeleteDuplicateOne {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteDuplicateOne solution = new DeleteDuplicateOne();
        ListNode listNode = solution.deleteDuplicates(node1);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                node1.next = node2.next;
                node2 = node1.next;
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return head;
    }
}