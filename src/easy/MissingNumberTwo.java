/**
 * @(#)MissingNumberTwo.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author wangweiwei
 */
public class MissingNumberTwo {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        MissingNumberTwo solution = new MissingNumberTwo();
        int i = solution.missingNumber(nums);
        System.out.println(i);
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 如果nums[mid] == mid，说明结果在[mid+1,right]
            if (nums[mid] == mid) {
                left = mid + 1;
            } // 否则结果在[left,mid-1]
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}