package medium;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring("b"));
    }

    public int lengthOfLongestSubstring(String s) {
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
