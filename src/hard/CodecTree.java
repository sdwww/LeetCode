/**
 * @(#)CodecTree.java, 10月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package hard;

import base.TreeNode;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author wangweiwei
 */
public class CodecTree {

    private int count = -1;

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

        CodecTree codecTree = new CodecTree();
        String serialize = codecTree.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codecTree.deserialize(serialize);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfsSerialize(root).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return dfsDeserialize(split);
    }

    private StringBuilder dfsSerialize(TreeNode root) {
        if (root == null) {
            return new StringBuilder("n,");
        }
        StringBuilder sb = new StringBuilder(root.val + ",");
        StringBuilder left = dfsSerialize(root.left);
        StringBuilder right = dfsSerialize(root.right);
        return sb.append(left).append(right);
    }

    private TreeNode dfsDeserialize(String[] split) {
        count++;
        if ("n".equals(split[count])) {
            return null;
        }
        int value = Integer.parseInt(split[count]);
        TreeNode treeNode = new TreeNode(value);
        treeNode.left = dfsDeserialize(split);
        treeNode.right = dfsDeserialize(split);
        return treeNode;
    }
}