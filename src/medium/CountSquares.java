package medium;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 */
public class CountSquares {

    public static void main(String[] args) {
        CountSquares solution = new CountSquares();
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(solution.countSquares(board));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                for (int k = 1; k <= Math.min(matrix.length - i, matrix[0].length - j); k++) {
                    if (isFillFullOne(matrix, i, j, k)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }


    private boolean isFillFullOne(int[][] matrix, int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
