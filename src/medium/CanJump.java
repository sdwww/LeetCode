package medium;

/**
 * 55. 跳跃游戏
 */
public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean jump = canJump.canJump(nums);
        System.out.println(jump);
    }

    // 贪心算法
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) {
                return false;
            }

           maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }

    // 动态规划
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
