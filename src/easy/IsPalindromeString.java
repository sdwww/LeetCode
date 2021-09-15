package easy;

/**
 * 125. 验证回文串
 *
 * @author wangweiwei
 */
public class IsPalindromeString {

    public static void main(String[] args) {
        IsPalindromeString solution = new IsPalindromeString();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}