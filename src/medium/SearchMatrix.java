package medium;

/**
 * 240. 搜索二维矩阵 II
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] board = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = searchMatrix.searchMatrix(board, 30);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target == matrix[x][y]) {
                return true;
            } else {
                y--;
            }
        }
        return false;
    }
}
