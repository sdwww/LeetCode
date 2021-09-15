package easy;

import base.TreeNode;

/**
 * 100. 相同的树
 *
 * @author wangweiwei
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode root2 = new TreeNode(1);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(20);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(7);
        root2.left = node5;
        root2.right = node6;
        node6.left = node7;
        node6.right = node8;
        IsSameTree isSameTree = new IsSameTree();
        boolean sameTree = isSameTree.isSameTree(root1, root2);
        System.out.println(sameTree);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}