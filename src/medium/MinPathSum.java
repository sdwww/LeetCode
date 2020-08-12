package medium;

/**
 * 64. 最小路径和
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum solution = new MinPathSum();
        int[][] arrays = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(arrays));
    }

    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                if (i == 1) {
                    sum[i][j] = sum[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    sum[i][j] = sum[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return sum[grid.length][grid[0].length];
    }
}
