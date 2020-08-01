package medium;

/**
 * 289. 生命游戏
 */
public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, boardCopy[i], 0, board[0].length);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveCount = 0;
                if (i - 1 >= 0) {
                    aliveCount += boardCopy[i - 1][j];
                    if (j - 1 >= 0) {
                        aliveCount += boardCopy[i - 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        aliveCount += boardCopy[i - 1][j + 1];
                    }
                }
                if (i + 1 < board.length) {
                    aliveCount += boardCopy[i + 1][j];
                    if (j - 1 >= 0) {
                        aliveCount += boardCopy[i + 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        aliveCount += boardCopy[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    aliveCount += boardCopy[i][j - 1];
                }
                if (j + 1 < board[0].length) {
                    aliveCount += boardCopy[i][j + 1];
                }
                if ((aliveCount < 2 || aliveCount > 3) && boardCopy[i][j] == 1) {
                    board[i][j] = 0;
                }
                if ((aliveCount == 3) && boardCopy[i][j] == 0) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
