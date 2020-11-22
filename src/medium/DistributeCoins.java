package medium;

import base.TreeNode;

/**
 * 979. 在二叉树中分配硬币
 */
public class DistributeCoins {

    private static int coins = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;

        DistributeCoins solution = new DistributeCoins();
        System.out.println(solution.distributeCoins(root));
    }

    public int distributeCoins(TreeNode root) {
        search(root);
        return coins;
    }

    private int search(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = search(node.left);
        int r = search(node.right);
        coins += Math.abs(l) + Math.abs(r) + node.val - 1;
        return node.val + l + r - 1;
    }
}
