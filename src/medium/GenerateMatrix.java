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
        int leftI = 0;
        int rightI = n - 1;
        int leftJ = 0;
        int rightJ = n - 1;
        int count = 1;
        int[][] arr = new int[n][n];
        while (leftI <= rightI && leftJ <= rightJ) {
            for (int i = leftJ; i <= rightJ; i++) {
                arr[leftI][i] = count++;
            }
            leftI++;
            for (int i = leftI; i <= rightI; i++) {
                arr[i][rightJ] = count++;
            }
            rightJ--;
            for (int i = rightJ; i >= leftJ; i--) {
                arr[rightI][i] = count++;
            }
            rightI--;
            for (int i = rightI; i >= leftI; i--) {
                arr[i][leftJ] = count++;
            }
            leftJ++;
        }
        return arr;
    }
}
