package easy;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 234. 回文链表
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(node1));
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddleNode(head);
        if (middle == null) {
            return true;
        }
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode newHead = reverseList(middleNext);
        return compare(head, newHead);

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

    private ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private boolean compare(ListNode head1, ListNode head2) {
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
