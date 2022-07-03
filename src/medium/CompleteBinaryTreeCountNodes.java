package medium;

import base.TreeNode;

/**
 * @date 2020/8/9 17:30
 * Description:222. 完全二叉树的节点个数
 */
public class CompleteBinaryTreeCountNodes {

    private int count = 0;

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

        CompleteBinaryTreeCountNodes solution = new CompleteBinaryTreeCountNodes();
        System.out.println(solution.countNodes(root));
    }

    /**
     * 暴力统计所有节点数量
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        search(root);
        return count;
    }

    private void search(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        search(treeNode.left);
        search(treeNode.right);
        count++;
    }
}
