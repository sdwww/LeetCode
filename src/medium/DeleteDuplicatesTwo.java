package medium;

import base.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author www
 */
public class DeleteDuplicatesTwo {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteDuplicatesTwo solution = new DeleteDuplicatesTwo();
        ListNode listNode = solution.deleteDuplicates(node1);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 设置虚拟节点
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}