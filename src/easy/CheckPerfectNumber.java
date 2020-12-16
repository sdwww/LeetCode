package easy;

/**
 * 507. 完美数
 */
public class CheckPerfectNumber {

    public static void main(String[] args) {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();
        boolean b = checkPerfectNumber.checkPerfectNumber(496);
        System.out.println(b);
    }


    public boolean checkPerfectNumber(int num) {
        int total = 0;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0 && num != i) {
                total += i;
                if (i != 1 && num / i != i) {
                    total += num / i;
                }
            }
        }
        return total == num;
    }
}
