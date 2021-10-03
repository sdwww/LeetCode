/**
 * @(#)ValidPalindrome.java, 10月 03, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * @author wangweiwei
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        boolean abac = solution.validPalindrome("abca");
        System.out.println(abac);
    }

    // 时间复杂度O(n)
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}