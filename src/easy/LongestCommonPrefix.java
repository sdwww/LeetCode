package easy;

/**
 * 14. 最长公共前缀
 *
 * @author www
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        // 找到字符串的最短长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        // 一位一位进行遍历，直到与一个元素不一致结束
        int index = -1;
        for (int i = 0; i < minLength; i++) {
            boolean different = false;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    different = true;
                    break;
                }
            }
            if (different) {
                break;
            }
            index = i;
        }
        return strs[0].substring(0, index + 1);
    }
}