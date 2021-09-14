package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author wangweiwei
 */
public class BuildTreeFromInAndPost {

    public static void main(String[] args) {
        BuildTreeFromInAndPost buildTree = new BuildTreeFromInAndPost();
        TreeNode treeNode = buildTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderList.add(inorder[i]);
            postorderList.add(postorder[i]);
        }
        return build(postorderList, inorderList);
    }

    private TreeNode build(List<Integer> postorderList, List<Integer> inorderList) {
        if (postorderList.isEmpty()) {
            return null;
        }
        Integer rootValue = postorderList.get(postorderList.size() - 1);
        TreeNode treeNode = new TreeNode(rootValue);
        int inorderIndex = inorderList.indexOf(rootValue);
        treeNode.left = build(postorderList.subList(0, inorderIndex), inorderList.subList(0, inorderIndex));
        treeNode.right = build(postorderList.subList(inorderIndex, postorderList.size() - 1), inorderList.subList(inorderIndex + 1, inorderList.size()));
        return treeNode;
    }
}