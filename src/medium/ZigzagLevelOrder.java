package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

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

        ZigzagLevelOrder solution = new ZigzagLevelOrder();
        solution.zigzagLevelOrder(root).forEach(System.out::print);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        // 增加标记位
        boolean leftOffer = true;
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                // 放入列表的头部或者尾部
                if (leftOffer) {
                    list.offerLast(pop.val);
                } else {
                    list.offerFirst(pop.val);
                }
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            lists.add(list);
            leftOffer = !leftOffer;
        }
        return lists;
    }
}
