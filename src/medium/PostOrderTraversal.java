package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class PostOrderTraversal {

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

        PostOrderTraversal solution = new PostOrderTraversal();
        System.out.println(solution.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrdersSearch(list, root);
        return list;
    }

    private void postOrdersSearch(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        postOrdersSearch(list, node.left);
        postOrdersSearch(list, node.right);
        list.add(node.val);
    }

}
