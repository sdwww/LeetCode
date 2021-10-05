/**
 * @(#)FindMaximumXOR.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 421. 数组中两个数的最大异或值 TODO
 *
 * @author wangweiwei
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        FindMaximumXOR solution = new FindMaximumXOR();
        int maximumXOR = solution.findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }

    public int findMaximumXOR(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result = Math.max(nums[i]^nums[j],result);
            }
        }
        return result;
    }
}