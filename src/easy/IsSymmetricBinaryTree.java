package easy;

import base.TreeNode;

import java.util.Objects;

/**
 * @date 2020/10/2 18:54
 * Description:剑指 Offer 28. 对称的二叉树
 */
public class IsSymmetricBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        IsSymmetricBinaryTree solution = new IsSymmetricBinaryTree();
        System.out.println(solution.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }
        if(!compare(left.left, right.right)){
            return false;
        }
        return compare(left.right,right.left);
    }
}
