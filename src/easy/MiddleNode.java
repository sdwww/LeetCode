package easy;

import base.ListNode;

/**
 * 876. 链表的中间结点
 *
 * @author wangweiwei
 */
public class MiddleNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        MiddleNode middleNode = new MiddleNode();
        ListNode listNode = middleNode.middleNode(node1);
        System.out.println(listNode);
    }

    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int mid = length / 2;
        while (mid > 0) {
            head = head.next;
            mid--;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}