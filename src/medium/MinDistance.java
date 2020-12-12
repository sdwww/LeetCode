package medium;

/**
 * 583. 两个字符串的删除操作
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance solution = new MinDistance();
        System.out.println(solution.minDistance("seat","eat"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (word1.charAt(i-1) ==word2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}
