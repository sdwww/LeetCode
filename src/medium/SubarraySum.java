package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 *
 * @author wangweiwei
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum solution = new SubarraySum();
        int[] nums = new int[]{1, 1, 1, 2};
        int i = solution.subarraySum(nums, 2);
        System.out.println(i);
    }

    // 时间复杂度O(n2)
    public int subarraySum1(int[] nums, int k) {
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

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        // key是sum,value是sum出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}