package hard;

import base.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 * @author wangweiwei
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseKGroup solution = new ReverseKGroup();
        ListNode listNode = solution.reverseKGroup(node1, 2);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 前一段的结尾
        ListNode preEnd = dummy;
        // 本段的结尾
        ListNode currentEnd = dummy;

        while (currentEnd.next != null) {
            for (int i = 0; i < k && currentEnd != null; i++) {
                currentEnd = currentEnd.next;
            }
            if (currentEnd == null) {
                break;
            }
            // 本段的开始
            ListNode currentStart = preEnd.next;
            // 下一段的开始
            ListNode nextStart = currentEnd.next;
            // 截断链表
            currentEnd.next = null;
            // 反转链表
            preEnd.next = reverseList(currentStart);
            // 反转之后的尾部连接下一段的头部
            currentStart.next = nextStart;
            // 当前的开始赋值给preEnd
            preEnd = currentStart;
            // 为了后续的遍历，currentEnd = preEnd
            currentEnd = preEnd;
        }

        return dummy.next;
    }


    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head.next.next;
        ListNode next = head.next;
        ListNode last = head;
        head.next = null;
        while (first != null) {
            next.next = last;
            last = next;
            next = first;
            first = first.next;
        }
        next.next = last;
        return next;
    }

}