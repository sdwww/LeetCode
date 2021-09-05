/**
 * @(#)IsPalindromeInteger.java, 9月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 9. 回文数
 *
 * @author wangweiwei
 */
public class IsPalindromeInteger {

    public static void main(String[] args) {
        IsPalindromeInteger solution = new IsPalindromeInteger();
        boolean palindrome = solution.isPalindrome(12321);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
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

}