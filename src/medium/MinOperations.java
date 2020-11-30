package medium;

/**
 * 1551. 使数组中所有元素相等的最小操作数
 */
public class MinOperations {

    public static void main(String[] args) {
        MinOperations solution = new MinOperations();
        System.out.println(solution.minOperations(8));
    }

    public int minOperations(int n) {
        return (n * n) >> 2;
    }
}
