/**
 * @(#)FindMaxLength.java, 9月 20, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 *
 * @author wangweiwei
 */
public class FindMaxLength {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        FindMaxLength solution = new FindMaxLength();
        int maxLength = solution.findMaxLength(nums);
        System.out.println(maxLength);
    }

    public int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;
        // 将0置为-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        // key是前几位的和，value是对应的i
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                result = Math.max(i - map.get(sum), result);
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }
}