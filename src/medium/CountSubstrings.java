/**
 * @(#)CountSubstrings.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 647. 回文子串
 *
 * @author wangweiwei
 */
public class CountSubstrings {

    private int count = 0;

    public static void main(String[] args) {
        CountSubstrings solution = new CountSubstrings();
        int i = solution.countSubstrings("abc");
        System.out.println(i);
    }

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            search(s,i,i);
            search(s,i,i+1);
        }
        return count;
    }

    private void search(String s,int left,int right){
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
    }
}