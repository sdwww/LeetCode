/**
 * @(#)BinaryTreePaths.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author wangweiwei
 */
public class BinaryTreePaths {

    private List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> list = solution.binaryTreePaths(root);
        System.out.println(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, List<Integer> tempList) {
        List<Integer> newList = new ArrayList<>(tempList);
        newList.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(buildString(newList));
            return;
        }
        if (node.left != null) {
            dfs(node.left, newList);
        }
        if (node.right != null) {
            dfs(node.right, newList);
        }
    }

    private String buildString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append("->").append(list.get(i));
        }
        return stringBuilder.toString();
    }
}