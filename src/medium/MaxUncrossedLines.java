package medium;

/**
 * 1035. 不相交的线
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {
        MaxUncrossedLines maxUncrossedLines = new MaxUncrossedLines();
        int[] array1 = {1, 3, 7, 1, 7, 5};
        int[] array2 = {1, 9, 2, 5, 1};
        System.out.println(maxUncrossedLines.maxUncrossedLines(array1, array2));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
