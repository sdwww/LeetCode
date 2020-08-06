package medium;

/**
 * 807. 保持城市天际线
 */
public class MaxIncreaseKeepingSkyline {

    public static void main(String[] args) {
        MaxIncreaseKeepingSkyline solution = new MaxIncreaseKeepingSkyline();
        int[][] arrs = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(solution.maxIncreaseKeepingSkyline(arrs));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] xMax = new int[grid[0].length];
        int[] yMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                xMax[j] = Math.max(grid[i][j], xMax[j]);
                yMax[i] = Math.max(grid[i][j], yMax[i]);
            }
        }
        int maxIncrease = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxIncrease += Math.min(xMax[j], yMax[i]) - grid[i][j];
            }
        }
        return maxIncrease;
    }
}
