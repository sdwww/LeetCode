/**
 * @(#)FindAnagrams.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author wangweiwei
 */
public class FindAnagrams {

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagrams = findAnagrams.findAnagrams("aa", "bb");
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = p.length() - 1;
        List<Integer> result = new ArrayList<>();

        // p的字符信息
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
        }

        // 滑动窗口初始的字符信息
        int[] slideChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            slideChars[s.charAt(i) - 'a']++;
        }

        // 进入滑动阶段
        while (right < s.length()) {
            if (same(chars, slideChars)) {
                result.add(left);
            }
            left++;
            right++;
            if (right >= s.length()) {
                break;
            }
            slideChars[s.charAt(left - 1) - 'a']--;
            slideChars[s.charAt(right) - 'a']++;

        }
        return result;
    }

    // 对比两个字符信息是否相同
    private boolean same(int[] chars, int[] slideChars) {
        for (int i = 0; i < 26; i++) {
            if (chars[i] != slideChars[i]) {
                return false;
            }
        }
        return true;
    }
}