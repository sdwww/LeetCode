package easy;

/**
 * 459. 重复的子字符串
 *
 * @author wangweiwei
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
        boolean b = solution.repeatedSubstringPattern("abcab");
        System.out.println(b);
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 暴力，时间复杂度O(n2)
    public boolean repeatedSubstringPattern1(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (repeatedSubstringPattern(s, s.substring(0, i))) {
                return true;
            }
        }
        return false;
    }

    private boolean repeatedSubstringPattern(String string, String subString) {
        if (string.length() % subString.length() != 0) {
            return false;
        }
        if (subString.length() == string.length()) {
            return false;
        }
        for (int i = 0; i < string.length() / subString.length(); i++) {
            if (!subString.equals(string.substring(i * subString.length(), (i + 1) * subString.length()))) {
                return false;
            }
        }
        return true;
    }
}