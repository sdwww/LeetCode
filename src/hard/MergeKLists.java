package hard;

import base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * @author wangweiwei
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;

        ListNode[] lists = new ListNode[]{listNode1, listNode4};
        MergeKLists solution = new MergeKLists();
        ListNode listNode = solution.mergeKLists(lists);
        System.out.println(listNode);
    }

    // 时间复杂度O(nk*log(k)),空间复杂度O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        // 优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
            current.next = minNode;
            current = current.next;
        }
        return dummy.next;
    }

    // 时间复杂度O(nk*k),空间复杂度O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (true) {
            ListNode minNode = null;
            // 最终选中的是第几个
            int selectIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    selectIndex = i;
                }
            }
            if (minNode == null) {
                break;
            }
            lists[selectIndex] = lists[selectIndex].next;
            current.next = minNode;
            current = current.next;
        }
        return dummy.next;
    }
}