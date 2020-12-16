package easy;

/**
 * 504. 七进制数
 */
public class ConvertToBase7 {
    public static void main(String[] args) {
        ConvertToBase7 solution = new ConvertToBase7();
        System.out.println(solution.convertToBase7(0));
    }

    public String convertToBase7(int num) {
        boolean positive = num >= 0;
        num = Math.abs(num);
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % 7);
            num /= 7;
        }
        if (!positive) {
            stringBuilder.append("-");
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.reverse().toString();
    }
}
