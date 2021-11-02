package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 */
public class FlattenTree {

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

        FlattenTree solution = new FlattenTree();
        solution.flatten(root);
        System.out.println(root);
    }

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 保存节点，接下来会有调整
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        flatten(left);
        flatten(right);
    }

    public void flatten1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void flatten(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        flatten(node.left, list);
        flatten(node.right, list);
    }
}
