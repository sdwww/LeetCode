package easy;

/**
 * 172. 阶乘后的零
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        TrailingZeroes solution = new TrailingZeroes();
        System.out.println(solution.climbStairs(1808548329));
    }

    public int climbStairs(int n) {
        int numFiveCount = 0;
        while(n/5>=1){
            numFiveCount+=n/5;
            n=n/5;
        }
        return numFiveCount;
    }
}
