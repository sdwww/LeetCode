package medium;

/**
 * 5. 最长回文子串
 *
 * @author www
 */
public class LongestPalindrome {

    int start = 0;
    int end = 0;

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = solution.longestPalindrome("abadf");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 类似 aa 这样的
            findIndex(s, i, i + 1);
            // 类似 aba这样的
            findIndex(s, i, i);
        }
        return s.substring(start, end + 1);
    }

    // 从中心点左右遍历
    private void findIndex(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > end - start) {
            start = left + 1;
            end = right - 1;
        }
    }
}