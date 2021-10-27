package hard;

import base.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author www
 */
public class TreeMaxPathSum {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-3);
        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node2.right = node4;

        TreeMaxPathSum solution = new TreeMaxPathSum();
        int i = solution.maxPathSum(root);
        System.out.println(i);
    }


    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxPath;
    }

    // 以node为末端节点的最大路径和
    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左子树的最大路径和，如果小于0则为0
        int leftSum = Math.max(getSum(node.left), 0);
        // 右子树的最大路径和，如果小于0则为0
        int rightSum = Math.max(getSum(node.right), 0);
        // 左子树和右子树的最大值
        int leftRightMax = Math.max(leftSum, rightSum);
        // 以node为拐点的最大路径和
        maxPath = Math.max(maxPath, leftSum + node.val + rightSum);
        // 返回最大值+当前值
        return leftRightMax + node.val;
    }
}