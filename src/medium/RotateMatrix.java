package medium;

/**
 * 48.旋转图像
 *
 * @author www
 */
public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix matrix = new RotateMatrix();
        int[][] nums = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        matrix.rotate(nums);
        for (int[] num : nums) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(num[j] + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i + j < matrix.length - 1) {
                    swap(matrix, i, j);
                }
            }
        }
    }

    private void swap(int[][] nums, int i, int j) {
        int length = nums.length;
        int temp = nums[i][j];
        nums[i][j] = nums[length - j - 1][i];
        nums[length - j - 1][i] = nums[length - i - 1][length - j - 1];
        nums[length - i - 1][length - j - 1] = nums[j][length - i - 1];
        nums[j][length - i - 1] = temp;
    }
}