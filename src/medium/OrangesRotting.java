package medium;

/**
 * 994. 腐烂的橘子
 */
public class OrangesRotting {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{2, 1, 1}, {1, 0, 0}, {0, 1, 1}};
        OrangesRotting solution = new OrangesRotting();
        int i = solution.orangesRotting(nums);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int[][] step = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, step, i - 1, j, 1);
                    dfs(grid, step, i + 1, j, 1);
                    dfs(grid, step, i, j - 1, 1);
                    dfs(grid, step, i, j + 1, 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果有新鲜橘子没遍历到，返回-1
                if (grid[i][j] == 1 && step[i][j] == 0) {
                    return -1;
                }
                if (grid[i][j] == 1) {
                    max = Math.max(step[i][j], max);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int[][] step, int i, int j, int depth) {
        // 越界判断
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        // 非新鲜橘子直接返回
        if (grid[i][j] != 1) {
            return;
        }
        // 如果已经遍历过，并且步数更少，直接返回
        if (step[i][j] != 0 && step[i][j] < depth) {
            return;
        }
        step[i][j] = depth;
        dfs(grid, step, i - 1, j, depth + 1);
        dfs(grid, step, i + 1, j, depth + 1);
        dfs(grid, step, i, j - 1, depth + 1);
        dfs(grid, step, i, j + 1, depth + 1);
    }
}
