package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return build(preorderList, inorderList);
    }

    private TreeNode build(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.isEmpty()) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorderList.get(0));
        int inorderIndex = inorderList.indexOf(preorderList.get(0));
        treeNode.left = build(preorderList.subList(1, inorderIndex + 1), inorderList.subList(0, inorderIndex));
        treeNode.right = build(preorderList.subList(inorderIndex + 1, preorderList.size()), inorderList.subList(inorderIndex + 1, inorderList.size()));
        return treeNode;
    }
}
