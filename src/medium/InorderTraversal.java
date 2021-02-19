package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {

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
        InorderTraversal inorderTraversal =new InorderTraversal();
        List<Integer> list = inorderTraversal.inorderTraversal(root);
        System.out.println(list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        search(root, list);
        return list;
    }
    // 递归，easy
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        search(root, list);
        return list;
    }

    private void search(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        search(treeNode.left, list);
        list.add(treeNode.val);
        search(treeNode.right, list);
    }
}
