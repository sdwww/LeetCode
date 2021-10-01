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
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 如果目标节点无子节点，直接将节点置为null
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                // 将这个左子树的最大值替换根节点，此时存在两个相同节点，将这个节点删除即可
                root.val = findLeftMax(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                // 将这个右子树的最小值替换根节点，此时存在两个相同节点，将这个节点删除即可
                root.val = findRightMin(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    // 找到一个节点左子树的最大节点
    private int findLeftMax(TreeNode treeNode) {
        TreeNode node = treeNode.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    // 找到一个节点右子树的最小节点
    private int findRightMin(TreeNode treeNode) {
        TreeNode node = treeNode.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
