package easy;

/**
 * 9. 回文数
 *
 * @author wangweiwei
 */
public class IsPalindromeInteger {

    public static void main(String[] args) {
        IsPalindromeInteger solution = new IsPalindromeInteger();
        boolean palindrome = solution.isPalindrome(12322);
        System.out.println(palindrome);
    }

    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        // 负数为false
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverse == x;
    }
}