package medium;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {

    private Node preNode;

    private Node head;

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node1 = new Node(1);
        Node node2 = new Node(20);
        Node node3 = new Node(0);
        Node node4 = new Node(5);
        Node node5 = new Node(15);
        Node node6 = new Node(26);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeToDoublyList solution = new TreeToDoublyList();
        Node node = solution.treeToDoublyList(root);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = preNode;
        preNode.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (preNode == null) {
            head = root;
        } else {
            root.left = preNode;
            preNode.right = root;
        }
        preNode = root;
        dfs(root.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
