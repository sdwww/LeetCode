package easy;

import base.ListNode;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RemoveElements solution = new RemoveElements();
        System.out.println(solution.removeElements(node1, 3));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode currentOld = head;
        ListNode currentNew = dummy;
        while (currentOld != null) {
            if (currentOld.val != val) {
                currentNew.next = currentOld;
                currentNew = currentNew.next;
            }
            currentOld = currentOld.next;
        }
        currentNew.next = null;
        return dummy.next;
    }
}
