package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * @author www
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int leftI = 0;
        int rightI = matrix.length - 1;
        int leftJ = 0;
        int rightJ = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        while (true) {
            // 向右移动
            for (int i = leftJ; i <= rightJ; i++) {
                list.add(matrix[leftI][i]);
            }
            leftI++;
            if (leftI > rightI) {
                break;
            }
            // 向下移动
            for (int i = leftI; i <= rightI; i++) {
                list.add(matrix[i][rightJ]);
            }
            rightJ--;
            if (leftJ > rightJ) {
                break;
            }
            // 向左移动
            for (int i = rightJ; i >= leftJ; i--) {
                list.add(matrix[rightI][i]);
            }
            rightI--;
            if (leftI > rightI) {
                break;
            }
            // 向上移动
            for (int i = rightI; i >= leftI; i--) {
                list.add(matrix[i][leftJ]);
            }
            leftJ++;
            if (leftJ > rightJ) {
                break;
            }
        }
        return list;
    }
}