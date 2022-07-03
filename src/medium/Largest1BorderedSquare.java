package medium;

/**
 * 1139. 最大的以 1 为边界的正方形o
 */
public class Largest1BorderedSquare {
    public static void main(String[] args) {
        Largest1BorderedSquare solution = new Largest1BorderedSquare();
//        int[][] board = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] board = {{0, 0, 0, 1}};
        System.out.println(solution.largest1BorderedSquare(board));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int maxCoverSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int coverSize = 0;
                for (int k = 1; k <= Math.min(grid.length - i, grid[0].length - j); k++) {
                    if (grid[i][j] == 0) {
                        break;
                    }
                    if (maxCoverSize < k * k) {
                        coverSize = coverSize(grid, i, j, k);
                    }
                    if (coverSize > maxCoverSize) {
                        maxCoverSize = coverSize;
                    }
                }
            }
        }
        return maxCoverSize;
    }

    private int coverSize(int[][] grid, int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if ((i == x || j == y || i == x + length - 1 || j == y + length - 1) && grid[i][j] == 0) {
                    return 0;
                }
            }
        }
        return length * length;
    }
}
