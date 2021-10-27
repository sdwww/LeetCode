package medium;

import base.Node;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
 * 剑指 Offer 35. 复杂链表的复制
 */
public class CopyRandomList {

    HashMap<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        Node node = copyRandomList.copyRandomList(node1);
        System.out.println(node.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.random.val);
    }

    // hash+递归
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.random = copyRandomList(head.random);
            newNode.next = copyRandomList(head.next);
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Node headCopy = new Node(head.val);
        Node nodeCopy = headCopy;
        while (node.next != null) {
            nodeCopy.next = new Node(node.next.val);
            nodeCopy = nodeCopy.next;
            node = node.next;
        }
        nodeCopy = headCopy;
        node = head;
        while (nodeCopy != null) {
            Node nodeTemp = null;
            if (node.random != null) {
                Node other = head;
                nodeTemp = headCopy;
                while (other != node.random && other != null) {
                    other = other.next;
                    nodeTemp = nodeTemp.next;
                }
            }
            nodeCopy.random = nodeTemp;
            nodeCopy = nodeCopy.next;
            node = node.next;
        }
        return headCopy;
    }
}
