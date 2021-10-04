/**
 * @(#)SingleNonDuplicate.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 540. 有序数组中的单一元素
 *
 * @author wangweiwei
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        SingleNonDuplicate solution = new SingleNonDuplicate();
        int i = solution.singleNonDuplicate(nums);
        System.out.println(i);
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 如果这个和后面数字相同
            if (nums[mid] == nums[mid + 1]) {
                // 如果mid前面是偶数个,说明结果在右边
                if ((mid - left) % 2 == 0) {
                    left = mid;
                } // 否则结果在左边
                else {
                    right = mid - 1;
                }
            } // 如果这个和前面数字相同
            else if (nums[mid] == nums[mid - 1]) {
                // 如果mid+1前面是偶数个,说明结果在右边
                if ((mid - left + 1) % 2 == 0) {
                    left = mid + 1;
                } // 否则结果在左边
                else {
                    right = mid;
                }
            }// 如果和前面后面都不一样，说明当前数字就是结果
            else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}