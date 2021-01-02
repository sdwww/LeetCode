package medium;

/**
 * 剑指 Offer 64. 求1+2+…+n
 */
public class SumNums {

    public static void main(String[] args) {
        SumNums solution = new SumNums();
        System.out.println(solution.sumNums(6));
    }

    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
