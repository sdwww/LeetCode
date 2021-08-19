package easy;

import base.TreeNode;

/**
 * 617. 合并二叉树
 *
 * @author www
 */
public class MergeTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node2.right = node4;


        MergeTrees mergeTrees = new MergeTrees();
        TreeNode treeNode = mergeTrees.mergeTrees(root1, new TreeNode(2));
        System.out.println(treeNode);
    }

    // 部分节点使用原树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }

    // 完全新建一棵树
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val;
        if (root1 == null) {
            val = root2.val;
        } else if (root2 == null) {
            val = root1.val;
        } else {
            val = root1.val + root2.val;
        }
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = mergeTrees1(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        treeNode.right = mergeTrees1(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return treeNode;
    }
}