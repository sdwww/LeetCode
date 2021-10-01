/**
 * @(#)Zconvert.java, 10月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 6. Z 字形变换
 *
 * @author wangweiwei
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        String convert = zConvert.convert("0123456789", 2);
        System.out.println(convert);
    }

    // 时间复杂度O(n)
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 每一组的大小为(numRows - 1) * 2
        int groupNums = (numRows - 1) * 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i <= s.length() / groupNums; i++) {
                int m = i * groupNums + j;
                int n = (i + 1) * groupNums - j;
                // 超界判断
                if (m < s.length()) {
                    stringBuilder.append(s.charAt(m));
                }
                // 可能为同一个节点
                if (m != n && m != n - groupNums && n < s.length()) {
                    stringBuilder.append(s.charAt(n));
                }
            }
        }
        return stringBuilder.toString();
    }
}