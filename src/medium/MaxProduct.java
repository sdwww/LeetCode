/**
 * @(#)MaxProduct.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 152. 乘积最大子数组
 *
 * @author wangweiwei
 */
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{-2,2,3};
        int i = maxProduct.maxProduct(nums);
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            // 如果元素为负责，最大值和最小值交换
            if (num < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            result = Math.max(imax, result);
        }
        return result;
    }
}