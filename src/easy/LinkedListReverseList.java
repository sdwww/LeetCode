package easy;

import base.ListNode;

/**
 * 206. 反转链表
 */
public class LinkedListReverseList {

    public static void main(String[] args) {
        LinkedListReverseList solution = new LinkedListReverseList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(solution.reverseList(node1));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head.next.next;
        ListNode nextNode = head.next;
        ListNode lastNode = head;
        lastNode.next =null;
        while (firstNode != null) {
            nextNode.next = lastNode;
            lastNode = nextNode;
            nextNode = firstNode;
            firstNode = firstNode.next;
        }
        nextNode.next =lastNode;
        return nextNode;
    }
}

