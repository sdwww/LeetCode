package medium;

/**
 * 45. 跳跃游戏 II
 *
 * @author www
 */
public class JumpGameTwo {

    public static void main(String[] args) {
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int jump = jumpGameTwo.jump(nums);
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if (dp[i + j] == 0) {
                        dp[i + j] = dp[i] + 1;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}