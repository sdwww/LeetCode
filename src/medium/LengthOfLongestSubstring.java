package medium;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    // 时间复杂度为O(n)
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer value = hashMap.get(s.charAt(i));
            if (value != null) {
                for (int j = start; j <= value; j++) {
                    hashMap.remove(s.charAt(j));
                }
                // 不重复的是value+1
                start = value + 1;
            }
            hashMap.put(s.charAt(i), i);
            if (end - start + 1 > max) {
                max = end - start + 1;
            }
            end++;
        }
        return max;
    }

    // 时间复杂度为O(n2)
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int rightStartIndex = 0;
        int rightEndIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.substring(rightStartIndex, i).lastIndexOf(s.substring(i, i + 1));
            if (charIndex != -1) {
                rightStartIndex = rightStartIndex + charIndex + 1;
            }
            if ((rightEndIndex - rightStartIndex) > (maxEndIndex - maxStartIndex)) {
                maxStartIndex = rightStartIndex;
                maxEndIndex = rightEndIndex;
            }
            rightEndIndex++;
        }
        return maxEndIndex - maxStartIndex + 1;
    }
}
