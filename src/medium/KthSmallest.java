package medium;

import java.util.Arrays;

/**
 * 378. 有序矩阵中第 K 小的元素
 *
 * @author wangweiwei
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallest kthSmallest = new KthSmallest();
        int i = kthSmallest.kthSmallest(nums, 8);
        System.out.println(i);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] nums = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[index++] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k - 1];
    }
}