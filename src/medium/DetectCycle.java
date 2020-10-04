package medium;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/8/15 13:15
 * Description:142. 环形链表 II
 */
public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle solution = new DetectCycle();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(solution.detectCycle(node1));
    }

    public ListNode detectCycle1(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            for (ListNode listNode : listNodes) {
                if (listNode == node) {
                    return node;
                }
            }
            listNodes.add(node);
            node = node.next;
        }
        return node;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast != slow && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast != slow) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = fast.next;
        while (node1 != null && node2 != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
