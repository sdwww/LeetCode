package medium;

/**
 * @author wangweiwei
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        MinSubArrayLen solution = new MinSubArrayLen();
        int[] nums = new int[]{1, 1, 1, 1, 11};
        int i = solution.minSubArrayLen(11, nums);
        System.out.println(i);
    }

    // 滑动窗口，时间复杂度O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = target + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            // 以left作为起点遍历
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == target + 1 ? 0 : minLen;
    }

    // 暴力超时，时间复杂度O(n2)
    public int minSubArrayLen1(int target, int[] nums) {
        int minLen = target + 1;
        for (int i = 0; i < nums.length; i++) {
            // 以i作为起点遍历
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen == target + 1 ? 0 : minLen;
    }
}