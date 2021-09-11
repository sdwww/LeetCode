/**
 * @(#)AddTwoNumberTwo.java, 9月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import base.ListNode;

import java.util.LinkedList;

/**
 * @author wangweiwei
 */
public class AddTwoNumberTwo {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(8);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        AddTwoNumberTwo solution = new AddTwoNumberTwo();
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<ListNode> resultStack = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        boolean moreThanNine = false;
        while (!stack1.isEmpty() || !stack2.isEmpty() || moreThanNine) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop();
            int value2 = stack2.isEmpty() ? 0 : stack2.pop();
            int add = value1 + value2 + (moreThanNine ? 1 : 0);
            moreThanNine = add >= 10;
            resultStack.push(new ListNode(add % 10));
        }

        ListNode dummyNode = new ListNode(0);
        ListNode listNode = dummyNode;
        while (!resultStack.isEmpty()) {
            listNode.next = resultStack.pop();
            listNode = listNode.next;
        }
        return dummyNode.next;
    }
}