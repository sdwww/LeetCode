/**
 * @(#)RemoveDuplicatesTwo.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * @author wangweiwei
 */
public class RemoveDuplicatesTwo {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        RemoveDuplicatesTwo solution = new RemoveDuplicatesTwo();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        for (int i = 2; i < result; i++) {
            while (nums[i] == nums[i - 2]) {
                leftMove(nums, i, result);
                result--;
                if (i >= result) {
                    break;
                }
            }
        }
        return result;
    }

    // 数据左移一位
    private void leftMove(int[] nums, int left, int right) {
        for (int i = left; i < right - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}