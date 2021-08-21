package medium;

import java.util.Arrays;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * @author www
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        int[] nums = new int[]{1, 3, 2, 6, 5};
//        int[] nums = new int[]{4, 6, 5, 7};
        boolean b = verifyPostorder.verifyPostorder(nums);
        System.out.println(b);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }
        // 找到分界点
        int splitIndex = -1;
        int last = postorder[postorder.length - 1];
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] > last) {
                splitIndex = i;
                break;
            }
        }
        for (int i = 0; i < splitIndex; i++) {
            if (postorder[i] > last) {
                return false;
            }
        }
        for (int i = splitIndex; i != -1 && i < postorder.length; i++) {
            if (postorder[i] < last) {
                return false;
            }
        }
        if (splitIndex == -1) {
            return verifyPostorder(Arrays.copyOfRange(postorder, 0, postorder.length - 1));
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, splitIndex))
                && verifyPostorder(Arrays.copyOfRange(postorder, splitIndex, postorder.length - 1));
    }
}