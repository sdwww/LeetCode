/**
 * @(#)IsRectangleOverlap.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 836. 矩形重叠
 *
 * @author wangweiwei
 */
public class IsRectangleOverlap {

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 1, 1};
        int[] nums2 = {1, 1, 3, 3};
        IsRectangleOverlap solution = new IsRectangleOverlap();
        boolean rectangleOverlap = solution.isRectangleOverlap(nums1, nums2);
        System.out.println(rectangleOverlap);
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 横坐标有交集并且纵坐标有交集
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }
}