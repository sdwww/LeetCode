package medium;

/**
 * 718. 最长重复子数组
 *
 * @author www
 */
public class LengthOfRepeatedSubarray {

    public static void main(String[] args) {
        LengthOfRepeatedSubarray solution = new LengthOfRepeatedSubarray();
        int[] nums1 = new int[]{0, 1, 1, 1, 1};
        int[] nums2 = new int[]{1, 0, 1, 0, 1};
        int length = solution.findLength(nums1, nums2);
        System.out.println(length);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        // 以num1[i]结尾和nums2[j]结尾的最长重复子数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}