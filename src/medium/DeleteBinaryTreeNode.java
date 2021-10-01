package medium;

import base.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class DeleteBinaryTreeNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(17);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        DeleteBinaryTreeNode solution = new DeleteBinaryTreeNode();
        TreeNode treeNode = solution.deleteNode(root, 10);
        System.out.println(treeNode);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 找到key对应的treeNode
        TreeNode searchNode = search(root, key);
        // 如果treeNode不存在，直接返回root
        if (searchNode == null) {
            return root;
        }
        if(searchNode.left==null &&searchNode.right==null){

        }
        return root;
    }

    private TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return root;
        }
        if (key > root.val) {
            return search(root.right, key);
        }
        return search(root.left, key);
    }
}
