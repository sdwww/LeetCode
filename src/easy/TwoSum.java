package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] numsPlusOne = solution.twoSum(nums, 17);

        for (int num : numsPlusOne) {
            System.out.println(num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return arr;
    }
}
