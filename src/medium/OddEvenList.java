package medium;

import base.ListNode;

/**
 * 328. 奇偶链表
 */
public class OddEvenList {

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
        OddEvenList betweenList = new OddEvenList();
        System.out.println(betweenList.oddEvenList(listNode1));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode evenNode = head.next;
        ListNode oddNode = head;
        // 注意顺序，先奇数后偶数
        while (oddNode.next != null && evenNode.next != null) {
            // 奇数节点进行连接
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            // 偶数节点进行连接
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;

        }
        oddNode.next = evenHead;
        return head;
    }
}
