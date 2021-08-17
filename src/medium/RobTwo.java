package medium;

/**
 * 213. 打家劫舍 II
 *
 * @author www
 */
public class RobTwo {

    public static void main(String[] args) {
        RobTwo robTwo = new RobTwo();
        int[] nums = {0, 0};
        int rob = robTwo.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] left = new int[nums.length - 1];
        int[] right = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            left[i] = nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            right[i] = nums[i + 1];
        }
        return Math.max(robInner(left), robInner(right));
    }

    private int robInner(int[] nums) {
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