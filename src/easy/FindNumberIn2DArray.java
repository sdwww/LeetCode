package easy;

/**
 * 剑指 Offer 04. 二维数组中的查找
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        FindNumberIn2DArray solution = new FindNumberIn2DArray();
//        System.out.println(solution.findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(solution.findNumberIn2DArray(new int[][]{{-1,3}}, 3));

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length)
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        return false;
    }
}
