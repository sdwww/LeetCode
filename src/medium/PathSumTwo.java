package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class PathSumTwo {

    public static void main(String[] args) {
        PathSumTwo solution = new PathSumTwo();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        solution.pathSum(root, 28).forEach(System.out::println);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        search(root, lists, list, targetSum);
        return lists;
    }

    private void search(TreeNode treeNode, List<List<Integer>> lists, List<Integer> list, int target) {
        List<Integer> listTemp = new ArrayList<>(list);
        listTemp.add(treeNode.val);
        if (treeNode.right == null && treeNode.left == null && target == treeNode.val) {
            lists.add(listTemp);
            return;
        }
        if (treeNode.left != null) {
            search(treeNode.left, lists, listTemp, target - treeNode.val);
        }
        if (treeNode.right != null) {
            search(treeNode.right, lists, listTemp, target - treeNode.val);
        }
    }
}
