/**
 * @(#)FindDuplicatesInArray.java, 9月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 *
 * @author wangweiwei
 */
public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        FindDuplicatesInArray solution = new FindDuplicatesInArray();
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println(duplicates);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num - 1] < 0) {
                list.add(num);
            } else {
                nums[num - 1] = -nums[num - 1];
            }
        }
        return list;
    }
}