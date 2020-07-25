/**
 * 111. 二叉树的最小深度
 */
public class TreeMinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeMinDepth solution = new TreeMinDepth();
        System.out.println(solution.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return search(root, 0);
    }

    private int search(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        if (node.left == null && node.right != null) {
            return search(node.right, depth + 1);
        }
        if (node.left != null && node.right == null) {
            return search(node.left, depth + 1);
        }
        int leftLength = search(node.left, depth + 1);
        int rightLength = search(node.right, depth + 1);
        return leftLength > rightLength ? rightLength : leftLength;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
