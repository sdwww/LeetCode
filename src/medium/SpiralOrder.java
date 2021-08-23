package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * 54. 螺旋矩阵
 *
 * @author www
 */
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(null);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int leftX = 0;
        int rightX = matrix.length;
        int leftY = 0;
        int rightY = matrix[0].length;
        List<Integer> list = new ArrayList<>(rightX * rightY);
        while (leftX < rightX && leftY < rightY) {
            for (int i = leftX; i < rightX; i++) {
                list.add(matrix[leftY][i]);
            }
            leftY++;
            for (int i = leftY; i < rightY; i++) {
                list.add(matrix[i][rightX]);
            }
        }
        return list;
    }
}