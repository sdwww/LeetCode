/**
 * @(#)TranslateNum.java, 8月 20, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author wangweiwei
 */
public class TranslateNum {

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int i = translateNum.translateNum(506);
        System.out.println(i);
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int temp = Integer.parseInt(s.substring(i - 2, i));
            if (temp <= 25 && temp >= 10) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length-1];
    }
}