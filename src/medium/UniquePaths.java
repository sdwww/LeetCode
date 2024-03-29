package medium;

import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(7, 3));
    }

    public int uniquePaths1(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < paths.length; i++) {
            paths[i][0] = 1;
        }
        Arrays.fill(paths[0], 1);
        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[0].length; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        long result = 1;
        int min = Math.min(m, n) - 1;
        for (int i = m + n - 2; i >= m + n - 1 - min; i--) {
            result = result * i;
        }
        for (int i = 1; i <= min; i++) {
            result /= i;
        }
        return (int) result;
    }
}
