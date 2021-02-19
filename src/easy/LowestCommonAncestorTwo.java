package easy;

import base.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorTwo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        LowestCommonAncestorTwo lowestCommonAncestor = new LowestCommonAncestorTwo();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, node3, node4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        // 平衡二叉树 父节点大于左子节点，小于右子节点，类似二分搜索往下走即可
        while (!between(root.val, p.val, q.val)) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    // 判断某个数字是否在两者之间
    private boolean between(int n, int x, int y) {
        if (x > y) {
            return n <= x && n >= y;
        }
        return n >= x && n <= y;
    }
}
