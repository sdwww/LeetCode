package medium;

/**
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {


    public static void main(String[] args) {
        GenerateMatrix solution = new GenerateMatrix();
        int[][] arr = solution.generateMatrix(6);
        for (int o = 0; o < arr.length; o++) {
            for (int p = 0; p < arr.length; p++) {
                System.out.print(arr[o][p] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int count = 1;
        int i = 0, j = -1;
        int[][] arr = new int[n][n];
        while (count <= n * n) {
            while (j + 1 < arr.length && arr[i][j + 1] == 0) {
                arr[i][j + 1] = count;
                j++;
                count++;
            }
            while (i + 1 < arr.length && arr[i + 1][j] == 0) {
                arr[i + 1][j] = count;
                i++;
                count++;
            }
            while (j > 0 && arr[i][j - 1] == 0) {
                arr[i][j - 1] = count;
                j--;
                count++;
            }
            while (i > 0 && arr[i - 1][j] == 0) {
                arr[i - 1][j] = count;
                i--;
                count++;
            }
        }
        return arr;
    }
}
