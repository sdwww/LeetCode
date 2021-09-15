package medium;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author wangweiwei
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        ThreeSumClosest solution = new ThreeSumClosest();
        int i = solution.threeSumClosest(nums, 1);
        System.out.println(i);
    }

    // 双指针，时间复杂度O(n2)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeNum = nums[i] + nums[left] + nums[right];
                if (Math.abs(threeNum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeNum;
                }
                if (threeNum > target) {
                    right--;
                } else if (threeNum < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return closestNum;
    }
}