package medium;

/**
 * 498. 对角线遍历
 *
 * @author www
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
                {7, 8, 9}};
        FindDiagonalOrder solution = new FindDiagonalOrder();
        int[] diagonalOrder = solution.findDiagonalOrder(nums);
        for (int j : diagonalOrder) {
            System.out.println(j);
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int count = 0;
        // 对角线的横坐标和纵坐标之和为常数i
        for (int i = 0; i < mat.length + mat[0].length - 1; i++) {
            for (int j = 0; j < mat.length && i - j >= 0; j++) {
                if (i % 2 == 0) {
                    continue;
                }
                // 边界控制
                if (i - j < 0 || i - j >= mat[0].length) {
                    continue;
                }
                result[count++] = mat[j][i - j];
            }
            for (int j = 0; j < mat[0].length; j++) {
                if (i % 2 == 1) {
                    continue;
                }
                // 边界空值
                if (i - j < 0 || i - j >= mat.length) {
                    continue;
                }
                result[count++] = mat[i - j][j];
            }
        }
        return result;
    }
}