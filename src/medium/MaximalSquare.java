package medium;

/**
 * 221. 最大正方形
 */
public class MaximalSquare {

    public static void main(String[] args) {

        char[][] nums = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        int i = maximalSquare.maximalSquare(nums);
        System.out.println(i);

    }

    public int maximalSquare(char[][] matrix) {
        return 0;
    }
}
