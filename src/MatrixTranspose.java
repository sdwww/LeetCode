import java.util.ArrayList;
import java.util.List;

/**
 * 867. 转置矩阵
 */
public class MatrixTranspose {

    public static void main(String[] args) {
        MatrixTranspose solution = new MatrixTranspose();
        int[][] arr = {{1,2,3},{4,5,6}};
        int[][] transpose = solution.transpose(arr);
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print((transpose[i][j]));
            }
            System.out.println();
        }
    }

    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                transpose[i][j] = A[j][i];
            }
        }
        return transpose;
    }
}
