/**
 * @(#)SubarraySum.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 560. 和为K的子数组
 *
 * @author wangweiwei
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum solution = new SubarraySum();
        int[] nums = new int[]{1, 1, 1};
        int i = solution.subarraySum(nums, 2);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}