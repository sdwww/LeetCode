package medium;

/**
 * 151. 翻转字符串里的单词
 *
 * @author www
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords(" a good example ");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            if (chars[right] == ' ') {
                reverse(chars, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] chars, int source, int target) {
        char temp = chars[source];
        chars[source] = chars[target];
        chars[target] = temp;
    }


    // 时间复杂度O(n),空间复杂度O(n)
    public String reverseWords1(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i])) {
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}