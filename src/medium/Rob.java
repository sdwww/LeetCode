package medium;

/**
 * 198. 打家劫舍
 *
 * @author www
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = {8, 9, 9, 4, 10, 5, 6, 9, 7, 9};
        System.out.println(rob.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}