package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class TreeLevelOrderThree {
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

        TreeLevelOrderThree solution = new TreeLevelOrderThree();
        solution.levelOrder(root).forEach(System.out::print);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> valueList = new LinkedList<>();
        List<TreeNode> first = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        first.add(root);
        boolean reverse = false;
        while (!first.isEmpty()) {
            for (TreeNode treeNode : first) {
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            List<Integer> list = first.stream().map(item -> item.val).collect(Collectors.toList());
            if (reverse) {
                Collections.reverse(list);
            }
            valueList.add(list);
            first = next;
            next = new LinkedList<>();
            reverse = !reverse;
        }
        return valueList;
    }
}
