package easy;

import base.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class ReversePrint {
    public static void main(String[] args) {
        ReversePrint solution = new ReversePrint();
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        int[] nums = solution.reversePrint(node1);
        for(int num:nums){
            System.out.println(num);
        }
        System.out.println();
    }

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] reverseArray = new int[len];
        node = head;
        while (node != null) {
            reverseArray[--len] = node.val;
            node = node.next;
        }
        return reverseArray;
    }
}
