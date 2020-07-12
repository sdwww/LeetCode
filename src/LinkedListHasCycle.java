/**
 * 141. 环形链表
 */
public class LinkedListHasCycle {

    public static void main(String[] args) {
        LinkedListHasCycle solution = new LinkedListHasCycle();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(solution.hasCycle(node1));
    }

    /**
     * 双指针
     *
     * @param head 头结点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast != slow && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
