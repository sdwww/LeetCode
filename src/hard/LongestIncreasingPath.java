package hard;

/**
 * 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int i = solution.longestIncreasingPath(matrix);
        System.out.println(i);
    }

    private int result = 1;

    public int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
                    continue;
                }
                if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
                    continue;
                }
                if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
                    continue;
                }
                if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
                    continue;
                }
                // 从最小值出发
                search(matrix, new int[matrix.length][matrix[0].length], i, j, 0);
            }
        }
        return result;
    }

    private void search(int[][] matrix, int[][] path, int i, int j, int currentPath) {
        if (path[i][j] != 0 && path[i][j] >= currentPath) {
            return;
        }
        currentPath++;
        path[i][j] = currentPath;
        result = Math.max(currentPath, result);
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            search(matrix, path, i - 1, j, currentPath);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            search(matrix, path, i + 1, j, currentPath);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            search(matrix, path, i, j - 1, currentPath);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            search(matrix, path, i, j + 1, currentPath);
        }
    }
}
