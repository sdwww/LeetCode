package easy;

import base.ListNode;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        System.out.println(getIntersectionNode.getIntersectionNodeEasy(listNode1, listNode3));
    }

    public ListNode getIntersectionNodeEasy(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 1.遍历确定两个链表的长度
        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }
        // 2.将两个链表按照尾部对齐
        nodeA = headA;
        nodeB = headB;
        if (lengthA > lengthB) {
            while (lengthA > lengthB) {
                nodeA = nodeA.next;
                lengthA--;
            }
        } else {
            while (lengthA < lengthB) {
                nodeB = nodeB.next;
                lengthB--;
            }
        }
        // 3.两个链表齐头并进，如果是相同的节点，则是相交的节点，否则返回null
        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

}
