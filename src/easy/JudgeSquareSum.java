package easy;

/**
 * 633. 平方数之和
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        JudgeSquareSum solution = new JudgeSquareSum();
        System.out.println(solution.judgeSquareSum(2147483644));
    }

    public boolean judgeSquareSum(int c) {
        int maxNum=(int)Math.sqrt(c);
        if(maxNum*maxNum==c){
            return true;
        }
        int maxNumHalf=(int)Math.sqrt(c/2);

        for(int j=maxNum;j>=maxNumHalf;j--){
            int k=(int)Math.sqrt(c-j*j);
            if(j*j+k*k==c){
                return true;
            }
        }

        return false;
    }
}
