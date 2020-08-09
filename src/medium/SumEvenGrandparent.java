package medium;

import base.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 */
public class SumEvenGrandparent {

    private int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        SumEvenGrandparent solution = new SumEvenGrandparent();
        System.out.println(solution.sumEvenGrandparent(root));
    }

    public int sumEvenGrandparent(TreeNode root) {
        search(root.left, root, null);
        search(root.right, root, null);
        return count;
    }

    private void search(TreeNode treeNode, TreeNode father, TreeNode grandparent) {
        if (treeNode == null) {
            return;
        }
        if (grandparent != null && grandparent.val % 2 == 0) {
            count += treeNode.val;
        }
        search(treeNode.left, treeNode, father);
        search(treeNode.right, treeNode, father);
    }
}
