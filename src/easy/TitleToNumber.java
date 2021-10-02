/**
 * @(#)TitleToNumber.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

/**
 * 171. Excel 表列序号
 *
 * @author wangweiwei
 */
public class TitleToNumber {

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        int ab = titleToNumber.titleToNumber("FXSHRXW");
        System.out.println(ab);
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int current = (columnTitle.charAt(i) - 'A' + 1);
            result = result * 26 + current;
        }
        return result;
    }
}