/**
 * @(#)FindLengthOfLCIS.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 674. 最长连续递增序列
 *
 * @author wangweiwei
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        FindLengthOfLCIS solution = new FindLengthOfLCIS();
        int lengthOfLCIS = solution.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                right++;
                max = Math.max(max, right - left + 1);
            } else {
                left = i;
                right = i;
            }
        }
        return max;
    }

}