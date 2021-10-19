package medium;

import base.ListNode;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(solution.addTwoNumbers(listNode1, listNode4));
    }

    // 循环的写法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode node1 = l1;
        ListNode node2 = l2;
        boolean moreThanNine = false;
        while (node1 != null || node2 != null || moreThanNine) {
            int i = node1 == null ? 0 : node1.val;
            int j = node2 == null ? 0 : node2.val;
            int sum = i + j + (moreThanNine ? 1 : 0);
            current.next = new ListNode(sum % 10);
            moreThanNine = sum >= 10;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode((l1.val + l2.val) % 10);
        if (l1.next != null || l2.next != null || (l1.val + l2.val) / 10 > 0) {
            listNode.next = addTwoNumbers(l1.next, l2.next, (l1.val + l2.val) / 10);
        }
        return listNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int addVal = l1.val + l2.val + add;
        ListNode listNode = new ListNode(addVal % 10);
        int mod = addVal / 10;
        if (l1.next != null || l2.next != null || mod > 0) {
            listNode.next = addTwoNumbers(l1.next, l2.next, mod);
        }
        return listNode;
    }
}
