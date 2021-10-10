package medium;

import base.TreeNode;

/**
 * 513. 找树左下角的值
 */
public class FindBottomLeftValue {

    private int maxLength = 0;

    private int maxValue = 0;

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

        FindBottomLeftValue solution = new FindBottomLeftValue();
        System.out.println(solution.findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        search(0, root);
        return maxValue;
    }

    // 前序遍历每一层的第一个节点
    private void search(int length, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        length++;
        if (length > maxLength) {
            maxValue = treeNode.val;
            maxLength = length;
        }
        search(length, treeNode.left);
        search(length, treeNode.right);
    }
}
