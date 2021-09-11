/**
 * @(#)IsAnagram.java, 9月 11, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 *
 * @author wangweiwei
 */
public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean anagram = isAnagram.isAnagram("bnagram", "nagaram");
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character) != 0) {
                return false;
            }
        }
        return true;
    }
}