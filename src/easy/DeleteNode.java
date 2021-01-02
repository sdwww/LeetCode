package easy;

import base.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode solution = new DeleteNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;
        System.out.println(solution.deleteNode(node1, 3));
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
