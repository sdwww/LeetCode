/**
 * @(#)SurroundRegion.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 130. 被围绕的区域
 *
 * @author wangweiwei
 */
public class SurroundRegion {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundRegion solution = new SurroundRegion();
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        // 从四个边缘进行扫描
        for (int i = 0; i < board.length; i++) {
            search(board, i, 0);
            search(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            search(board, 0, i);
            search(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void search(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        search(board, i - 1, j);
        search(board, i + 1, j);
        search(board, i, j - 1);
        search(board, i, j + 1);
    }
}