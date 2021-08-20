package medium;

/**
 * 79. 单词搜索
 * 剑指 Offer 12. 矩阵中的路径
 *
 * @author www
 */
public class MatrixWordSearch {

    public static void main(String[] args) {

        char[][] word = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] word = new char[][]{{'A', 'A', 'C', 'E'}};
        MatrixWordSearch solution = new MatrixWordSearch();
        boolean exist = solution.exist(word, "ABCESEEEFS");
//        boolean exist = solution.exist(word, "AAA");
        System.out.println(exist);

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] came = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, came, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean search(char[][] board, boolean[][] came, String leftWord, int x, int y) {
        // 遍历完成返回true
        if (leftWord.length() == 0) {
            return true;
        }
        // 超界返回false
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        // 数值不相等返回false
        if (board[x][y] != leftWord.charAt(0)) {
            return false;
        }
        // 已经访问过直接返回
        if (came[x][y]) {
            return false;
        }
        // 当前位置标记为来过
        came[x][y] = true;
        // 四个方向进行搜索
        if (search(board, came, leftWord.substring(1), x - 1, y)) {
            return true;
        }
        if (search(board, came, leftWord.substring(1), x, y - 1)) {
            return true;
        }
        if (search(board, came, leftWord.substring(1), x + 1, y)) {
            return true;
        }
        if (search(board, came, leftWord.substring(1), x, y + 1)) {
            return true;
        }
        // 重置标记
        came[x][y] = false;
        return false;
    }
}